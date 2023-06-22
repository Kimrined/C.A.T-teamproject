package com.CAT.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName="set")

public class ResponseDto<D> {
	private boolean result;
	private String message;
	private D data;

	public static <D> ResponseDto<D> setSuccess(String message, D data){
		return ResponseDto.setSuccess(message, data);
	}

	public static <D> ResponseDto<D> setFailed(boolean b, String message){
		return ResponseDto.setFailed(false, message);
	}
}
