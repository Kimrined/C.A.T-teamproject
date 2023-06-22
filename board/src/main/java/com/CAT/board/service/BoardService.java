package com.CAT.board.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CAT.board.dto.ResponseDto;
import com.CAT.board.entity.BoardEntity;
import com.CAT.board.entity.PopularSearchEntity;
import com.CAT.board.repository.BoardRepository;
import com.CAT.board.repository.PopularSearchRepository;

@Service
public class BoardService {

	@Autowired BoardRepository boardRepository;
	@Autowired PopularSearchRepository popularSearchRepository;
	
	public ResponseDto<List<BoardEntity>> getTop3() {
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		Date date = Date.from(Instant.now().minus(7, ChronoUnit.DAYS));
		
		try {
			boardList = boardRepository.findTop3ByBoardWriteDateAfterOrderByBoardLikesCountDesc(null);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed(false, "Database Error");
		}
		
		return ResponseDto.setSuccess("Success", boardList);
	}
	
	public ResponseDto<List<BoardEntity>> getList () {
		List<BoardEntity> boarList = new ArrayList<BoardEntity>();
		
		try {
			boarList = boardRepository.findByOrderByBoardWriteDateDesc();
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed(false, "Database Error");
		}
		
		return ResponseDto.setSuccess("Success", boarList);
	}
	
	public ResponseDto<List<PopularSearchEntity>> getPopularsearchList () {
		List<PopularSearchEntity> popularSearchList = new ArrayList<PopularSearchEntity>();
		
		try {
			popularSearchList = popularSearchRepository.findTop10ByOrderByPopularSearchCountDesc();
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed(false, "Database Error");
		}
		
		return ResponseDto.setSuccess("Success", popularSearchList);
	}
	
	public ResponseDto<List<BoardEntity>> getSearchList(String boardTitle) {
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		
		try {
			boardList = boardRepository.findByBoardTitleContains(boardTitle);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed(false, "Database Error");
		}
		
		return ResponseDto.setSuccess("Success", boardList);
	}
}
