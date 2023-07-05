package org.web.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BoardDto {
	private Long board_id;
	private String board_title;
	private String board_content;
	private String board_writer;
	private Timestamp create_time;
	
	public BoardDto() {
		super();
	}

	public BoardDto(Long board_id, String board_title, String board_content, String board_writer,
			Timestamp create_time) {
		super();
		this.board_id = board_id;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_writer = board_writer;
		this.create_time = create_time;
	}

	public Long getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Long board_id) {
		this.board_id = board_id;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "BoardDto [board_id=" + board_id + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_writer=" + board_writer + ", create_time=" + create_time + "]";
	}
	
	
}
