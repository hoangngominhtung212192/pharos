package com.pharos.ws;

import javax.ws.rs.GET;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.AuthorDTO;


@RestController
public interface AuthorWS {
	
	@GET
	@RequestMapping(value = "/author/findAuthorById")
	AuthorDTO getAuthorById(@RequestParam("authorId") int authorId);
}
