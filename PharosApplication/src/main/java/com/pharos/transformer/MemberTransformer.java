package com.pharos.transformer;

import org.springframework.stereotype.Service;

import com.pharos.dto.MemberDTO;
import com.pharos.entity.Member;

@Service
public interface MemberTransformer {
	Member convertToEntity(MemberDTO dto);

	MemberDTO convertToDTO(Member entity);

}
