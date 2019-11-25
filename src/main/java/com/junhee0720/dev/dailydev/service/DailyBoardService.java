package com.junhee0720.dev.dailydev.service;

import com.junhee0720.dev.dailydev.domain.DailyBoard;
import com.junhee0720.dev.dailydev.repository.DailyBoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class DailyBoardService {

	private DailyBoardRepository dailyBoardRepository;

	public List<DailyBoard> getAllDailyBoard(){
		return dailyBoardRepository.findAll();
	}

	public DailyBoard getDailyBoard(Long id){
		DailyBoard dailyBoard = dailyBoardRepository.findById(id).orElse(null);
		if(dailyBoard == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board Not Found");
		}else {
			return dailyBoard;
		}
	}

	public DailyBoard createDailyBoard(DailyBoard dailyBoard){
		dailyBoard.setCurrentTime();
		return dailyBoardRepository.save(dailyBoard);
	}

	public DailyBoard updateDailyBoard(Long id, DailyBoard dailyBoard){
		DailyBoard saveDailyBoard = dailyBoardRepository.findByIdAndWriter(id, dailyBoard.getWriter()).orElse(null);
		if(saveDailyBoard == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board Not Found");
		}else{
			saveDailyBoard.update(dailyBoard);
			return dailyBoardRepository.save(dailyBoard);
		}
	}

	public void deleteDailyBoard(Long id, DailyBoard dailyBoard){

		DailyBoard deleteDailyBoard = dailyBoardRepository.findByIdAndWriter(id, dailyBoard.getWriter()).orElse(null);
		if(deleteDailyBoard == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board Not Found");
		}else{
			dailyBoardRepository.deleteById(id);
		}
	}
}
