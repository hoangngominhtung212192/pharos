/**
 * 
 */
package com.pharos.ws;

import javax.ws.rs.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tung Hoang Ngo Minh
 *
 */

@RestController
public interface LanguageWS {
	
	@POST
	@RequestMapping(value = "/language/create")
	ResponseEntity<Integer> createLanguage();
}
