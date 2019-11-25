package com.junhee0720.dev.dailydev.repository;

import com.junhee0720.dev.dailydev.domain.DailyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DailyBoardRepository extends JpaRepository<DailyBoard, Long> {

	public Optional<DailyBoard> findByIdAndWriter(Long id, String write);

	List<DailyBoard> findByWriter(String writer);



}
