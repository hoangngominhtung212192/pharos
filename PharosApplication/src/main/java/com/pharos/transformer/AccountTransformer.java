package com.pharos.transformer;

import org.springframework.stereotype.Service;

import com.pharos.dto.AccountDTO;
import com.pharos.entity.Account;

@Service
public interface AccountTransformer {
	Account convertToEntity(AccountDTO dto);

	AccountDTO convertToDTO(Account account);
	
	AccountDTO convertDataToAccountDto(String data, int roleId);
}
