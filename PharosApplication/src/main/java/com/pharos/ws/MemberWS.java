package com.pharos.ws;

import javax.ws.rs.GET;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharos.dto.MemberDTO;

@RestController
public interface MemberWS {
	
	@GET
	@RequestMapping(value = "/member/findMemberById")
	MemberDTO getMemberById(@RequestParam("memberId") int memberId);
}
