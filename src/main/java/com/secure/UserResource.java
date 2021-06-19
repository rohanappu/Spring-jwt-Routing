package com.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.dao.AuthenticationRequest;
import com.secure.dao.AuthenticationResponse;
import com.secure.repository.MyUserDetailsService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserResource {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	MyUserDetailsService userDetailsService;
	@Autowired
	JwtUtil jwtTokenUtil;
	@RequestMapping("/s")
	//@CrossOrigin(origins = "http://localhost:8080")
	public String home() {
		return "Success.html";
	}
   
	@PostMapping("/authenticate")
	
	//@CrossOrigin(origins = "http:\\\\localhost:8080")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		} catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt=jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
@GetMapping("/getUser")
	
	//@CrossOrigin(origins = "http:\\\\localhost:8080")
	public ResponseEntity<?> getUser() throws Exception{
	   MyData data = new MyData();
	   data.setName("Rajesh");
	   data.setTask("lenskart");
		return new ResponseEntity<>(data,HttpStatus.OK);
		
	}
	
	
}
