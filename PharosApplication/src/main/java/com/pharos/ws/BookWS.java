package com.pharos.ws;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pharos.dto.BookDTO;
import com.pharos.dto.ResultResponseDTO;

@RestController
public interface BookWS {

	@POST
	@RequestMapping(value = "book/upload")
	ResponseEntity<ResultResponseDTO> createBook(@RequestParam("file") MultipartFile file,
			@RequestParam("book_info") String bookInfo);

	@GET
	@RequestMapping(value = "/book/getAllBooks")
	List<BookDTO> getAllBooks(@RequestParam("memberId") int memberId);

	@GET
	@RequestMapping(value = "/book/getAllBookTypes")
	List<String> getAllTypes(@RequestParam("bookId") int bookId);

	@POST
	@RequestMapping(value = "/book/readBook")
	Map<String, byte[]> readBook(@RequestParam("bookId") int bookId);

	@GET
	@RequestMapping(value = "/book/searchByTitle")
	List<BookDTO> searchByTitle(@RequestParam("title") String title);
}
