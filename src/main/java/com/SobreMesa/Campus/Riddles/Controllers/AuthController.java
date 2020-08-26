package com.SobreMesa.Campus.Riddles.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SobreMesa.Campus.Riddles.Services.AuthService;
import com.SobreMesa.Campus.Riddles.dto.AuthenticationResponse;
import com.SobreMesa.Campus.Riddles.dto.LoginRequest;
import com.SobreMesa.Campus.Riddles.dto.RegisterRequest;
import com.SobreMesa.Campus.Riddles.entity.Hunter;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("signup")
	public AuthenticationResponse signup(@RequestBody RegisterRequest registerRequest) {
		return authService.signup(registerRequest);
		//return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
	}
	
	@PostMapping("login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}
	
	@GetMapping("user")
	public Hunter getUserDetails(@RequestParam("hunter_username") String hunter_username) {
		
		System.out.println("hit user details end");
		
		return authService.getHunterDetails(hunter_username);
	}
	
	/*
	 * TODO: 
	 * 		add account verification (token verification method). the tutorial shows how and it starts at 
	 * 		29 minutes 10 seconds on this video https://www.youtube.com/watch?v=DKlTBBuc32c
	 */
}
