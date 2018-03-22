package com.pharos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.dto.TypeDTO;
import com.pharos.exception.BusinessException;

@Service
@Transactional
public interface BookTypeService {
	List<TypeDTO> loadTypes();

	List<String> getListTypesByBookId(int id) throws BusinessException;
}
