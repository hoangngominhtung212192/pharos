package com.pharos.ws.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pharos.dto.AuthorDTO;
import com.pharos.dto.ResultResponseDTO;
import com.pharos.service.AuthorService;
import com.pharos.service.UploadBookService;
import com.pharos.transformer.AccountTransformer;
import com.pharos.transformer.AuthorTransformer;
import com.pharos.ws.AuthorWS;

@RestController
public class AuthorWsImpl implements AuthorWS {
}
