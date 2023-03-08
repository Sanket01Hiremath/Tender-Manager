package com.example.Exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyErrorDetails {

	private LocalDateTime timeStamp;
	private String msg;
	private String details;
	
	
}
