/**
 * 
 */
package com.pharos.ws;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.BookDTO;
import com.pharos.dto.CartDTO;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@RestController
public interface StoreWS {
	
	@GET
	@RequestMapping(value="/store/didBuyBook")
	Map<String, Boolean> didBuyBook(@RequestParam("memberId") int memberId, @RequestParam("bookId") int bookId);
	
	@POST
	@RequestMapping(value="/store/shoppingBook")
	Map<String, Boolean> shoppingBook(@RequestParam("memberId") int memberId, @RequestParam("bookId") int bookId);
	
	@GET
	@RequestMapping(value="/store/getPurchasedBooks")
	List<BookDTO> getAllPurchasedBooks(@RequestParam("memberId") int memberId);
}
