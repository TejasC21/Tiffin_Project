package com.app.tiffin.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.tiffin.dtos.Credential;
import com.app.tiffin.dtos.DtoEntityConverter;
import com.app.tiffin.dtos.UserDto;
import com.app.tiffin.entities.User;
import com.app.tiffin.exceptions.ResourceNotFoundException;
import com.app.tiffin.repository.UserDao;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private DtoEntityConverter converter;
	@Autowired
	private PasswordEncoder passwardencoder;

	public UserDto findUserById(int userId) {
		User user = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found!!!"));
		return converter.toUserDto(user);
	}

	public UserDto findUserByEmail(String email) {
		User user = userDao.findByEmail(email);
		return converter.toUserDto(user);
	}
	
	public UserDto findUserByEmailAndPassword(Credential cred) {
		User user = userDao.findByEmail(cred.getEmail());
		String rawpassword = cred.getPassword();
		System.out.println(cred);
		if(user!=null && passwardencoder.matches(rawpassword ,user.getPassword())) {
			return converter.toUserDto(user);
		}
		return null;
	}
	
	public UserDto AddUser(UserDto userdto) {
		String rawpassword = userdto.getPassword();
		System.out.println(rawpassword);
		String encrpassword = passwardencoder.encode(rawpassword);
		userdto.setPassword(encrpassword);
		userDao.save(converter.UserDtotoUser(userdto));
		return userdto;
	}
	
	public List<UserDto> DeliveryBoysList(){
		List<User>  list=	userDao.findAll();
		List<UserDto> dlist=new ArrayList<UserDto>();
		for(User u:list) {
			if(u.getRole().equals("delivery")) 
				dlist.add(converter.toUserDto(u));
		}
		return dlist;
	}
	
	public User DeleteUser(int userId) {
		User u = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found!!!"));
		System.out.println(u);
		userDao.delete(u);
		return u;
	}
	
	public List<UserDto> getAllCustomers(){
		List<User> users = userDao.findAll();
		List<UserDto> userlist = new ArrayList<UserDto>();
		for(User u : users) {
			if(u.getRole().equals("user")) {
				userlist.add(converter.toUserDto(u));
			}
		}
		return userlist;
	}
	
	public Map<String, Object> editUser(int userId, UserDto dto){
		User user = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found!!!"));
		user.setUserName(dto.getUserName());
		user.setEmail(dto.getEmail());
		user.setPassword(passwardencoder.encode(dto.getPassword()));
		user.setPhone(dto.getPhone());
		user.setRole(dto.getRole());
		user.setAadharNo(dto.getAadharNo());
		user = userDao.save(user);
		return Collections.singletonMap("userUpdated", 1);
	}
}
