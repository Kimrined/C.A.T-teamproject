package com.CAT.board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CAT.board.dto.PatchUserDto;
import com.CAT.board.dto.PatchUserResponseDto;
import com.CAT.board.dto.ResponseDto;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@PatchMapping("/")
	public ResponseDto<PatchUserResponseDto> patchUser(@RequestBody PatchUserDto requestBody, @AuthenticationPrincipal String userEmail) {
		return null;
	}
}
