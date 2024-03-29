package com.example.doctor.appointment.smsSending;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {
	@NotBlank
	private String phoneNumber;//DestinationPhno
	
	@NotBlank
	private String message;
	
	
	public SmsRequest() {
		
	}


	public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber, 
			@JsonProperty("message") String message) {
		
		this.phoneNumber = phoneNumber;
		this.message = message;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "SmsRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}

	
}
