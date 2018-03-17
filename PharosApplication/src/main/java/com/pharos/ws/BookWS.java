package com.pharos.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pharos.dto.BookDTO;

@RestController
public interface BookWS {

	@POST
	@RequestMapping(value="book/upload")
	ResponseEntity<Integer> createBook(@RequestParam("file") MultipartFile file);
	
	@GET
	@RequestMapping(value="/book/getAllBooks")
	List<BookDTO> getAllBooks(@RequestParam("memberId") int memberId);
}
