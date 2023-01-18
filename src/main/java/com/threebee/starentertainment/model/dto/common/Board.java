package com.threebee.starentertainment.model.dto.common;

import java.sql.Timestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Board {

	private int id;
	private String title;
	private String content;
	private Timestamp createDate;
	private String username;
	//user
	
}
