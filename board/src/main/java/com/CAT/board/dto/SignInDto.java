package com.CAT.board.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignInDto {
	@NotBlank
	private String userEmail;
	@NotBlank
	private String UserPassword;
	public String getUserEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUserPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
