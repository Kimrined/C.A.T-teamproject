package com.CAT.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.CAT.board.dto.ResponseDto;
import com.CAT.board.dto.SignInDto;
import com.CAT.board.dto.SignInResponseDto;
import com.CAT.board.dto.SignUpDto;
import com.CAT.board.entity.UserEntity;
import com.CAT.board.repository.UserRepository;
import com.CAT.board.security.TokenProvider;

@Service
public class AuthService {
	
	@Autowired UserRepository userRepository;
	@Autowired TokenProvider tokenProvider;
	
	//private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public ResponseDto<?> SignUp(SignUpDto dto){
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		String userPasswordCheck = dto.getUserPasswordCheck();
		
		// email �ߺ� Ȯ��
		try {
			if(userRepository.existsById(userEmail))
				return ResponseDto.setFailed(false, "Existed Email");
		} catch (Exception error) {
			return ResponseDto.setFailed(false, "Data Base Error!");
		}
		
		
		// ��й�ȣ�� ���� �ٸ��� failed response ��ȯ!
		if(!userPassword.equals(userPasswordCheck))
			return ResponseDto.setFailed(false, "Password does not matched!");
			
		// UserEntity ����
		UserEntity userEntity = new UserEntity(dto); 
		/**
		// ��й�ȣ ��ȣȭ
		String encodedPassword = passwordEncoder.encode(userPassword);
		userEntity.setUserPassword(encodedPassword); **/
		
		// UserRepository�� �̿��ؼ� �����ͺ��̽��� Entity ����!
		try {
			userRepository.save(userEntity);
		} catch(Exception error) {
			return ResponseDto.setFailed(false, "Data Base Error!");
		}
		
		// ���� ��, Success response ��ȯ
		return ResponseDto.setSuccess("Sign Up Success!", null);
	}
	
	public ResponseDto<SignInResponseDto> SignIn(SignInDto dto) {
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		
		UserEntity userEntity = null;
		
		/**try {
			userEntity = userRepository.findByUserEmail(userEmail);
			// �߸��� �̸���
			if(userEntity == null) return ResponseDto.setFailed(false, "Sign In Failed");
			// �߸��� �н�����
			if(!passwordEncoder.matches(userPassword, userEntity.getUserPassword()))
				return ResponseDto.setFailed(false, "Sign In Failed");
		} catch (Exception error) {
			return ResponseDto.setFailed(false, "Database Error");
		}**/
		
		userEntity.setUserPassword("");
		
		String token = tokenProvider.create(userEmail);
		int exprTime = 3600000;
		
		SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);
		return ResponseDto.setSuccess("Sign In Success", signInResponseDto);
	}
}