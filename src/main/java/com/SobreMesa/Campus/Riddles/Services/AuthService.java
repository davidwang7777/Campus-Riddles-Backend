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

import com.SobreMesa.Campus.Riddles.entity.CRUser;
import com.SobreMesa.Campus.Riddles.entity.Hunter;
import com.SobreMesa.Campus.Riddles.entity.VerificationToken;
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
	
	public void signup(RegisterRequest registerRequest) {
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
		
		String token = generateVerificationToken(user);
	}
	
	private String generateVerificationToken(Hunter hunter) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(hunter);
		
		verificationTokenRepository.save(verificationToken);
		return token;
	}

	public void login(LoginRequest loginRequest) {
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
    		   loginRequest.getPassword()));
	}
}
