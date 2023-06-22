package com.CAT.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CAT.board.dto.ResponseDto;
import com.CAT.board.entity.BoardEntity;
import com.CAT.board.entity.PopularSearchEntity;
import com.CAT.board.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	/**
	@Autowired BoardService boardService;

	@GetMapping("/top3")
	public ResponseDto<List<BoardEntity>> getTop3() {
		return boardService.getTop3();
	}
	
	@GetMapping("/list")
	public ResponseDto<List<BoardEntity>> getList() {
		return boardService.getList();
	}
	
	@GetMapping("/popularsearchList")
	public ResponseDto<List<PopularSearchEntity>> getpopularsearchList() {
		return boardService.getPopularsearchList();
	}
	
	@GetMapping("/search/{title}")
	public ResponseDto<List<BoardEntity>> getSearchList (@PathVariable("boardTitle") String title) {
		return null;
	}**/
}
