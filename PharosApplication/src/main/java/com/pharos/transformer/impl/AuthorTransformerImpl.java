/**
 * 
 */
package com.pharos.transformer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pharos.dto.AuthorDTO;
import com.pharos.entity.Account;
import com.pharos.entity.Author;
import com.pharos.transformer.AuthorTransformer;

/**
 * @author TOSHIBA
 *
 */
@Service
public class AuthorTransformerImpl implements AuthorTransformer {

	private static final Logger LOGGER = LogManager.getLogger(AuthorTransformerImpl.class);
	
	/* (non-Javadoc)
	 * @see com.pharos.transformer.AuthorTransformer#convertDataToAuthorDto(java.lang.String)
	 */
	@Override
	public AuthorDTO convertDataToAuthorDto(String data) {
		LOGGER.info("Begin convertDataToAuthorDto with data: {}", data);
		String[] info=data.split("\\|");
		String email=info[0];
		String name=info[1];
		String tel=info[2];
		String address=info[3];
		
		AuthorDTO dto=new AuthorDTO();
		dto.setEmail(email);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddress(address);
		
		LOGGER.info("End  convertDataToAuthorDto with result: {}", dto.toString());
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.pharos.transformer.AuthorTransformer#convertDtoToEntity(com.pharos.dto.AuthorDTO)
	 */
	@Override
	public Author convertDtoToEntity(AuthorDTO authorDto) {
		Author author=new Author();
		LOGGER.info("Begin convertDtoToEntity with data: {}", authorDto.toString());
		int accountId=authorDto.getAccountId();
		Account account=new Account();
		account.setId(accountId);
		
		author.setAccount(account);
		author.setAddress(authorDto.getAddress());
		author.setAvatar(authorDto.getAvatar());
		author.setBackCardImg(authorDto.getBackCardImg());
		author.setCardNo(author.getCardNo());
		author.setEmail(authorDto.getEmail());
		author.setFrontCardImg(authorDto.getFrontCardImg());
		author.setMotto(authorDto.getMotto());
		author.setName(authorDto.getName());
		author.setTel(authorDto.getTel());
		
		LOGGER.info("End convertDtoToEntity with result: {}", author.toString());
		return author;
	}

	@Override
	public AuthorDTO convertToDto(Author author) {
		LOGGER.info("Begin convertToDto with Author Entity ID: {}", author.getId());
		
		AuthorDTO dto = null;
		if(author != null) {
			dto = new AuthorDTO();
			dto.setId(author.getId());
			dto.setAccountId(author.getAccount().getId());
			dto.setAddress(author.getAddress());
			dto.setAvatar(author.getAvatar());
			dto.setEmail(author.getEmail());
			dto.setBackCardImg(author.getBackCardImg());
			dto.setFrontCardImg(author.getFrontCardImg());
			dto.setCardNo(author.getCardNo());
			dto.setMotto(author.getMotto());
			dto.setName(author.getName());
			dto.setTel(author.getTel());
		}
		LOGGER.info("End convertToDto with Author DTO ID: {}", dto.getId());
		return dto;
	}

}
