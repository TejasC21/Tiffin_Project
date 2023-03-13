package com.app.tiffin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.tiffin.dtos.Credential;
import com.app.tiffin.dtos.Response;
import com.app.tiffin.dtos.UserDto;
import com.app.tiffin.services.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/{id}")
	public ResponseEntity<?> displayUserById(@PathVariable("id") int id) {
		UserDto userDto = userService.findUserById(id);
		return Response.success(userDto);
	}
	
	@PostMapping("/user/email")
	public ResponseEntity<?> Signin(@RequestBody Credential cred) {
		UserDto userDto = userService.findUserByEmailAndPassword(cred);
		if(userDto == null) 
			Response.error("Incorrect username and password");
		return Response.success(userDto);
	}
	
	@PostMapping("/signup/users")
	public ResponseEntity<?> Signup(@RequestBody UserDto userdto){
		UserDto result = userService.AddUser(userdto);
		if(result==null)  
			return Response.error("Something wrong happened");
		return Response.success(result);
		
	}
	
	@GetMapping("/DeliveryBoys")
	public ResponseEntity<?> findalldeliveryBoys(){
		return Response.success(userService.DeliveryBoysList());
	}
	
	@PostMapping("/DeliveryBoys/Delete")
	public ResponseEntity<?> deleteDeliveryboy(@RequestBody ObjectNode objectNode){
	
		int id=Integer.parseInt(objectNode.get("userId").asText());
		System.out.println(id);
		return Response.success(userService.DeleteUser(id));
	}
	
	@GetMapping("/CustomerList")
	public ResponseEntity<?> getAllCustomers(){
	
		return Response.success(userService.getAllCustomers());
	}
	
	@PutMapping("/user/edit/{userId}")
	public ResponseEntity<?> editUser(@RequestBody UserDto dto,@PathVariable Integer userId){
	       Map<String, Object> result = userService.editUser(userId, dto);
	       return Response.success(result);
	   }
}

