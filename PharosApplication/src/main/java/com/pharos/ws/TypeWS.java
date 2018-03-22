/**
 * 
 */
package com.pharos.ws;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.TypeDTO;

/**
 * @author TOSHIBA
 *
 */
@RestController
public interface TypeWS {
	@GET
	@RequestMapping(value="/type/getAllType")
	ResponseEntity<List<TypeDTO>> getAllType();
}
