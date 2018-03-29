package com.pharos.ws;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pharos.dto.AccountDTO;
import com.pharos.dto.ResultResponseDTO;

@RestController
public interface AccountWS {

	@GET
	@RequestMapping(value = "/account/login")
	HashMap<String, Integer> checkLogin(String username, String password);

	@POST
	@RequestMapping(value = "/account/registration")
	String registratrion(String username, String password, String email, String tel);

	@POST
	@RequestMapping(value = "/author/regist")
	ResponseEntity<ResultResponseDTO> registAuthor(@RequestParam("accountInfo") String accountInfo,
			@RequestParam("authorInfo") String authorInfo, @RequestParam("frontImage") MultipartFile frontImage,
			@RequestParam("backImage") MultipartFile backImage, HttpServletRequest request);

	@GET
	@RequestMapping(value = "/account/checkAccount")
	ResponseEntity<ResultResponseDTO> checkAccount(@RequestParam("username") String username);
}
