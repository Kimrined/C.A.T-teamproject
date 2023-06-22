package com.CAT.board.dto;

import com.CAT.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {
	public SignInResponseDto(String token2, int exprTime2, UserEntity userEntity) {
		// TODO Auto-generated constructor stub
	}
	private String token;
	private int exprTime;
	private UserEntity user;
}
