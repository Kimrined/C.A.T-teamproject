package com.CAT.board.dto;

import com.CAT.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserResponseDto {
	
	public PatchUserResponseDto(UserEntity userEntity) {
		// TODO Auto-generated constructor stub
	}

	private UserEntity user;
}
