package com.example.crud.example.Exception;

import java.time.LocalDate;

public class Errordetails {
    private String message;
    private LocalDate date;
    private String details;
 
 public Errordetails()
 {
	 
 }

public Errordetails(String message, LocalDate date, String details) {
	super();
	this.message = message;
	this.date = date;
	this.details = details;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}


}
	

