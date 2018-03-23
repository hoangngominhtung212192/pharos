package com.pharos.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.pharos.dto.BookDTO;
import com.pharos.dto.CartDTO;

import springfox.documentation.spring.web.json.Json;

@RestController
public interface BookWS {

	@POST
	@RequestMapping(value="book/upload")
	ResponseEntity<JsonObject> createBook(@RequestParam("file") MultipartFile file, @RequestParam("book_info") String bookInfo);
	
	@GET
	@RequestMapping(value="/book/getAllBooks")
	List<BookDTO> getAllBooks(@RequestParam("memberId") int memberId);
	
	@GET
	@RequestMapping(value="/book/getAllBookTypes")
	List<String> getAllTypes(@RequestParam("bookId") int bookId);
	
	@POST
	@RequestMapping(value="/book/downloadBook")
	CartDTO redownloadBook(@RequestParam("bookId") int bookId);
}
