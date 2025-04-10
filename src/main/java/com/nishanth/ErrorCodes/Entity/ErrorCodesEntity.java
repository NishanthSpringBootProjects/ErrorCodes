package com.nishanth.ErrorCodes.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class ErrorCodesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int errorCode;
	private String errorMessage;
	private String errorDescription;
	private String locale;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	@Override
	public String toString() {
		return "ErrorCodesEntity [id=" + id + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", errorDescription=" + errorDescription + ", locale=" + locale + "]";
	}

}
