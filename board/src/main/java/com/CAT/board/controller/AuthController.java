package com.CAT.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CAT.board.dto.ResponseDto;
import com.CAT.board.dto.SignInDto;
import com.CAT.board.dto.SignInResponseDto;
import com.CAT.board.dto.SignUpDto;
import com.CAT.board.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired AuthService authService;
	
	@PostMapping("/signUp")
	
	public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
		//System.out.println(requestBody.toString());
		ResponseDto<?> result = authService.SignUp(requestBody);
		return result;
	}
	
	@PostMapping("/signIn")
	public ResponseDto<SignInResponseDto> sigIn(@RequestBody SignInDto requestBody) {
		ResponseDto<SignInResponseDto> result = authService.SignIn(requestBody);
		return result;
	}
}
