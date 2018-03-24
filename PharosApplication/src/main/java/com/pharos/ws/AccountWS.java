package com.pharos.ws;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.AccountDTO;

@RestController
public interface AccountWS {
	
	@GET
	@RequestMapping(value = "/account/login")
	HashMap<String, Integer> checkLogin(String username , String password);
	
	@POST
	@RequestMapping(value = "/account/registration")
	String registratrion(String username ,String password, String email, String tel);
}
