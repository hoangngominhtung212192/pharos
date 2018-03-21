package com.pharos.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.AccountDTO;

@RestController
public interface AccountWS {
	
	@GET
	@RequestMapping(value = "/account/login")
	ResponseEntity<String> checkLogin(@RequestBody AccountDTO dto);
	
	@POST
	@RequestMapping(value = "/account/registration")
	ResponseEntity<String> registratrion();
}
