package com.SobreMesa.Campus.Riddles.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SobreMesa.Campus.Riddles.Services.AuthService;
import com.SobreMesa.Campus.Riddles.dto.AuthenticationResponse;
import com.SobreMesa.Campus.Riddles.dto.LoginRequest;
import com.SobreMesa.Campus.Riddles.dto.RegisterRequest;

@RestController
@RequestMapping("api/auth")
public class Auth {
	
	@Autowired
	private AuthService authService;

	@PostMapping("signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
	}
	
	@PostMapping("login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		System.out.println("part 1");
		return authService.login(loginRequest);
	}
	
	/*
	 * TODO: 
	 * 		add account verification (token verification method). the tutorial shows how and it starts at 
	 * 		29 minutes 10 seconds on this video https://www.youtube.com/watch?v=DKlTBBuc32c
	 */
}
