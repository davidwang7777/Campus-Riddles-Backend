package com.SobreMesa.Campus.Riddles.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("/signup")
	public void signup(@RequestBody RegisterRequest registerRequest) {}
	
	@PostMapping("/login")
	public void login(@RequestBody LoginRequest loginRequest) {
		authService.login(loginRequest);
	}
}
