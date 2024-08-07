package com.LoginSingin.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.LoginSingin.entity.LoginRequest;
import com.LoginSingin.entity.RegisterUser;
import com.LoginSingin.services.UserService;



@RestController
public class UserSigninController {
	  private final UserService service;


	    public UserSigninController(UserService service) {
			super();
			this.service = service;
		}


		@PostMapping("/RegisterUser")
	    public ResponseEntity<?> signUpUser(@RequestBody RegisterUser user) {
	        // Check if the user with the given email already exists
	        if (service.existsByName(user.getName())) {
	            // Return a conflict status with a clear message
	            return ResponseEntity.status(HttpStatus.CONFLICT)
	                    .body("Email is already registered"); 
	        }

	        RegisterUser savedUser = service.save(user);

	        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(savedUser.getName())  // Use user ID as identifier in the URI
	                .toUri();

	        return ResponseEntity.created(location).body(savedUser);
	    }
		

		@PostMapping("/login")
		public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
		    String message = service.login(loginRequest.getName(), loginRequest.getPassword());
		    return ResponseEntity.ok(message);
		}

}
