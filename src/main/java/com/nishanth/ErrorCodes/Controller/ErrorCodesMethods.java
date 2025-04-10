package com.nishanth.ErrorCodes.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nishanth.ErrorCodes.Entity.ErrorCodesEntity;

public interface ErrorCodesMethods {

	String insertMessages();

	ArrayList<ErrorCodesEntity> insertMessages(ErrorCodesEntity errorCodes);

	ArrayList<ErrorCodesEntity> getMessages(String errorMessage, String locale);
	

}