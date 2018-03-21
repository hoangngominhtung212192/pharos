package com.pharos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pharos.dto.TypeDTO;

@Service
@Transactional
public interface TypeService {
	List<TypeDTO> loadTypes();
}
