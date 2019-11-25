package com.junhee0720.dev.dailydev.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Table(name = "daily_board")
@Entity
public class DailyBoard {

	@Id @GeneratedValue
	@Column(name = "board_id")
	private Long id;

	private String writer;

	private LocalDateTime registerDate;

	private LocalDateTime updateDate;

	private String title;

	private String content;


	public void setCurrentTime(){
		this.registerDate = LocalDateTime.now();
		this.updateDate   = LocalDateTime.now();
	}

	public void update(DailyBoard dailyBoard){
		this.content = dailyBoard.content;
		this.title = dailyBoard.title;
		this.updateDate = LocalDateTime.now();
	}

}
