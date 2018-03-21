package com.pharos.transformer;

import com.pharos.dto.AccountDTO;
import com.pharos.entity.Account;

public interface AccountTransformer {
	Account convertToEntity(AccountDTO dto);

	AccountDTO convertToDTO(Account account);
}
