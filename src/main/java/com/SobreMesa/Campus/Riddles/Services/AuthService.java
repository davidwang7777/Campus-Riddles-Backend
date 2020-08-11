package com.SobreMesa.Campus.Riddles.Services;

import java.time.Instant;
import java.util.UUID;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.Hunter;
import com.SobreMesa.Campus.Riddles.entity.VerificationToken;
import com.SobreMesa.Campus.Riddles.Security.JwtProvider;
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
	private final JwtProvider jwtProvider;
	
	public void signup(RegisterRequest registerRequest) {
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
		
		hunterRepo.save(user);
		
		//String token = generateVerificationToken(user);
		
		// this token above is used to send to the email to be verified. 
	}
	
	public AuthenticationResponse login(LoginRequest loginRequest) {
		
		org.springframework.security.core.Authentication authenticate = null;
		
		try {
		authenticate = 
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
		} catch (Exception e ) {
			e.printStackTrace();
		}
	       System.out.println("step 2: " + authenticate.isAuthenticated());
	       SecurityContextHolder.getContext().setAuthentication(authenticate);
	       String token = "8888";//jwtProvider.generateToken(authenticate);
	       System.out.println("this is token: " + token);
	       return new AuthenticationResponse(token, loginRequest.getUsername());
//		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), 
//				loginRequest.getPassword()));
	}
	
	private String generateVerificationToken(Hunter hunter) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(hunter);
		
		verificationTokenRepository.save(verificationToken);
		return token;
	}
}
