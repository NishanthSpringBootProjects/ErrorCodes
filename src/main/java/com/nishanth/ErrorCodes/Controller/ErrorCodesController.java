package com.nishanth.ErrorCodes.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nishanth.ErrorCodes.Entity.ErrorCodesEntity;
import com.nishanth.ErrorCodes.Service.ErrorCodesService;

@RestController()
@RequestMapping("/errorcodes")
public class ErrorCodesController implements ErrorCodesMethods {
	
	
	@Autowired
	private ErrorCodesService errorCodesService;
	
	@Override
	@GetMapping
	public String insertMessages() {
		return "welcome....errorCodes Page";
	}
	
	@Override
	@PostMapping("/insert" )
	public ArrayList<ErrorCodesEntity>  insertMessages(@RequestBody ErrorCodesEntity errorCodes ) {
		System.out.println(errorCodes);
		ArrayList<ErrorCodesEntity> errorcode=errorCodesService.insertmsg(errorCodes);
		return errorcode;
	}
	
	
	@Override
	@GetMapping("/getmessages" )
	public ArrayList<ErrorCodesEntity> getMessages(@RequestParam("errorMessage") String errorMessage,@RequestParam(name= "locale", required= false) String locale  ) {
		System.out.println(errorMessage);
		if(locale == null) {
		   return errorCodesService.getmsg(errorMessage);
		}
		
		return errorCodesService.getMsByLocale(errorMessage,locale);
	}
	
	

}
