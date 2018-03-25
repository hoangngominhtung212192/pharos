package com.pharos.ws.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pharos.dto.AccountDTO;
import com.pharos.dto.AuthorDTO;
import com.pharos.dto.MemberDTO;
import com.pharos.dto.ResultResponseDTO;
import com.pharos.dto.RoleDTO;
import com.pharos.service.AccountService;
import com.pharos.service.AuthorService;
import com.pharos.service.MemberService;
import com.pharos.service.RoleService;
import com.pharos.service.UploadBookService;
import com.pharos.transformer.AccountTransformer;
import com.pharos.transformer.AuthorTransformer;
import com.pharos.ws.AccountWS;

@RestController
public class AccountWsImpl implements AccountWS {

	@Autowired
	AccountService accountService;
	@Autowired
	MemberService memberService;
	@Autowired
	RoleService roleService;
	@Autowired
	AuthorService authorService;
	@Autowired
	AuthorTransformer authorTransformer;
	@Autowired
	AccountTransformer accountTransformer;
	@Autowired
	UploadBookService upload;

	private static final Logger LOGGER = LogManager.getLogger(AccountWsImpl.class);

	@Override
	public HashMap<String, Integer> checkLogin(String username, String password) {
		LOGGER.info("Begin login in Account WS with username - password: {}", username + " - " + password);
		AccountDTO accountDTO = null;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		try {
			accountDTO = new AccountDTO();
			accountDTO = accountService.login(username, password);
			LOGGER.info("End login in Account WS with username - password : {}", username + " - " + password);
			if (accountDTO != null) {
				hm.put("roleID", accountDTO.getRoleId());
				if (accountDTO.getRoleId() == 2) {
					int memberId = memberService.findMemberIdByAccountId(accountDTO);
					hm.put("ID", memberId);
					return hm;
				} else if (accountDTO.getRoleId() == 3) {

				}

			} else {
				hm.put("roleID", -1);
				hm.put("ID", -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hm;
	}

	@Override
	public String registratrion(String username, String password, String email, String tel) {
		String status = "";
		int accountId = -1;
		AccountDTO accountDTO = new AccountDTO();

		accountDTO.setUsername(username);
		accountDTO.setPassword(password);
		accountDTO.setRoleId(2);
		accountDTO.setEnable(true);
		LOGGER.info("Begin registration with AccountDTO Id : " + accountDTO.getId());
		if (accountDTO != null) {
			try {
				accountId = accountService.registration(accountDTO);
				LOGGER.info("End registration with AccountDTO Id : " + accountDTO.getUsername());
				if (accountId > -1) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setAccountId(accountId);
					// Date dob = new SimpleDateFormat("dd/MM/yyyy").parse("17/02/1997");
					memberDTO.setEmail(email);
					memberDTO.setTel(tel);
					memberDTO.setMoney(0);
					LOGGER.info("Begin registration with MemberDTO Id : " + memberDTO.getAccountId());
					memberService.registration(memberDTO);
					LOGGER.info("End registration with MemberDTO Id : " + memberDTO.getAccountId());
					status = "Successfull";
				} else if (accountId == -1) {
					status = "Existed";
				}

			} catch (Exception e) {
				System.out.println(e);
				status = "Fail SML";
			}
		}
		return status;
	}

	@Override
	public ResponseEntity<ResultResponseDTO> checkAccount(String username) {
		boolean existUser = accountService.checkAccountValidation(username);

		ResultResponseDTO resultResponse = new ResultResponseDTO();
		ResponseEntity<ResultResponseDTO> response = null;

		if (!existUser) {
			resultResponse.setStatus("FALSE");
			resultResponse.setMessage("Username is existed");
			response = new ResponseEntity<ResultResponseDTO>(resultResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			resultResponse.setStatus("Ok");
			resultResponse.setMessage("Username is accepted");
			response = new ResponseEntity<ResultResponseDTO>(resultResponse, HttpStatus.ACCEPTED);
		}
		return response;
	}

	@Override
	public ResponseEntity<ResultResponseDTO> registAuthor(String accountInfo, String authorInfo,
			MultipartFile fronImage, MultipartFile backImage) {
		ResponseEntity<ResultResponseDTO> response = null;
		ResultResponseDTO responseDTO = new ResultResponseDTO();
		
		
		LOGGER.info("Begin registration author with data: " + accountInfo + " and " + authorInfo);
		AuthorDTO authorDTO = authorTransformer.convertDataToAuthorDto(authorInfo);
		String email = authorDTO.getEmail();

		LOGGER.info("Begin check duplicate email: " +email);
		if (!authorService.checkEmail(email)) {
			responseDTO.setStatus("Failed");
			responseDTO.setMessage("Email is duplicate");
			LOGGER.error(email+" is duplicated");
			
			response = new ResponseEntity<ResultResponseDTO>(responseDTO, HttpStatus.CONFLICT);
		} else {
			LOGGER.info("Begin create account with data : " + accountInfo);
			
			AccountDTO accountDTO = accountTransformer.convertDataToAccountDto(accountInfo, 3);
			accountDTO.setEnable(true);
			int accId = accountService.registration(accountDTO);

			if (accId == -1) {
				responseDTO.setStatus("Failed");
				responseDTO.setMessage("Can't create account");
				LOGGER.error("Create account failed!");
				response = new ResponseEntity<ResultResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}

			else {
				LOGGER.info("Begin create author with data : " + authorInfo);
				String fronImageLocate = upload.saveBook(fronImage);
				String backImageLocate = upload.saveBook(backImage);

				authorDTO.setBackCardImg(backImageLocate);
				authorDTO.setFrontCardImg(fronImageLocate);
	
				authorDTO.setAccountId(accId);
				authorDTO.setAvatar("null");
				authorDTO.setCardNo(0);
				authorDTO.setMotto("null");
				
				
				int authorId=authorService.createAuthor(authorDTO);
				if (authorId<0) {
					responseDTO.setStatus("Failed");
					responseDTO.setMessage("Can't create author");
					LOGGER.error("Create author failed!");
					
					response = new ResponseEntity<ResultResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
				}else {
					responseDTO.setStatus("Ok");
					responseDTO.setMessage("Create account sucess!");
					response = new ResponseEntity<ResultResponseDTO>(responseDTO, HttpStatus.OK);
					LOGGER.info("create author sucess with id: " +accId);
				}
			}
		}
		LOGGER.info("End registration author");
		return response;
	}

}
