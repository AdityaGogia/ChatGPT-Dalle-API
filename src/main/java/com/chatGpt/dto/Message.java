package com.chatGpt.dto;

import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	private String id;
	private String conversationID;
	private String userContent;
	private String aiContent;
	private Date timeStamp;
	private boolean deleted;
	private List<Inten> intents;
	private List<Entit> entities;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	public static class Inten {
		private String category;
		private double confidenceScore;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	public static class Entit {
		private String category;
		private String text;
		private int offset;
		private int length;
		private double confidenceScore;
	}

}
