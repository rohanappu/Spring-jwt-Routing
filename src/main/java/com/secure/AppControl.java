package com.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.dao.AuthenticationRequest;
import com.secure.dao.AuthenticationResponse;
import com.secure.dao.Login;
import com.secure.repository.MyUserDetailsService;

@Controller
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AppControl {
	
//	@RequestMapping("/success")
//	public String home() {
//		return "Success";
//	}
	@RequestMapping("/login")
	public String login() {
		return "Home.html";
		
	}
	 
	@RequestMapping("/Howli")
	public String Success() {
		System.out.println("testing");
		return "Success.html";
	}

}
