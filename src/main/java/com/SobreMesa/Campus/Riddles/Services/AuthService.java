package com.SobreMesa.Campus.Riddles.Services;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.Hunter;
import com.SobreMesa.Campus.Riddles.entity.VerificationToken;
import com.SobreMesa.Campus.Riddles.Security.JwtUtil;
import com.SobreMesa.Campus.Riddles.dto.AuthenticationResponse;
import com.SobreMesa.Campus.Riddles.dto.LoginRequest;
import com.SobreMesa.Campus.Riddles.dto.RegisterRequest;
import com.SobreMesa.Campus.Riddles.repo.HunterRepository;
import com.SobreMesa.Campus.Riddles.repo.VerificationTokenRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {
	
	private final PasswordEncoder passwordEncoder;
	private final HunterRepository hunterRepo;
	private final AuthenticationManager authenticationManager;
	private final VerificationTokenRepository verificationTokenRepository;
	private final JwtUtil jwtUtil;
	
	public AuthenticationResponse signup(RegisterRequest registerRequest) {
		/*
		 * This method is specifically for signing up as a Hunter
		 */
		Hunter user = new Hunter();
		user.setUsername(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode( registerRequest.getPassword() ));
		user.setCreated(Instant.now());

		
		
		/*
		 * by default a user is NOT enabled, meaning he hasn't verified his email. So when he does, then 
		 * we will setEnabled(true) 
		 */
		user.setEnabled(false);
		try {
			hunterRepo.save(user);
		}catch(DataIntegrityViolationException e) {
			
			System.out.println(e.getLocalizedMessage()); 
			
			return new AuthenticationResponse("", "", "FAIL");
		}
		//catch duplicate username HERE
		
		//String token = generateVerificationToken(user);
		
		// this token above is used to send to the email to be verified. 
		
		 return new AuthenticationResponse("", "", "SUCCESS");
	}
	
	public AuthenticationResponse login(LoginRequest loginRequest) {
		
		org.springframework.security.core.Authentication authenticate = null;
		try {
		authenticate = 
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
		} catch (Exception e ) {
			System.out.println(e.getMessage());
			//TODO: add a proper response here. ie. return "bad credentials message from here"
			return new AuthenticationResponse("", "", "FAIL");
			
		}
	       System.out.println("step 2: " + authenticate.isAuthenticated());
	       //SecurityContextHolder.getContext().setAuthentication(authenticate);
	       String token = jwtUtil.generateToken(loginRequest.getUsername());
	       return new AuthenticationResponse(token, loginRequest.getUsername(), "SUCCESS");
	}
	
	public Hunter getHunterDetails(String hunter_username) {
		
		Optional<Hunter> hunterOptional = hunterRepo.findByUsername(hunter_username);
		
		if (hunterOptional.isPresent()) {
			Hunter hunter = hunterOptional.get();
			return hunter;
		}else {
			return null;
		}
		
	}
	
	
	private String generateVerificationToken(Hunter hunter) {
		/*
		 * this method is used to generate the token that gets sent out to the users 
		 * email address to verify their account exists
		 * 
		 * soon to be implemented
		 */
		
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(hunter);
		
		verificationTokenRepository.save(verificationToken);
		return token;
	}
}
