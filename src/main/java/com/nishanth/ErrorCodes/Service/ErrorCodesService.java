package com.nishanth.ErrorCodes.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishanth.ErrorCodes.Entity.ErrorCodesEntity;
import com.nishanth.ErrorCodes.Repo.ErrorCodesRepo;

@Service
public class ErrorCodesService {

	@Autowired
	private ErrorCodesRepo errorCodesRepo;
	
	public ArrayList<ErrorCodesEntity>  insertmsg(ErrorCodesEntity errorCodes) {
		ArrayList<ErrorCodesEntity> errorcode = errorCodesRepo.finderrorMessageByLocale(errorCodes.getErrorMessage(),errorCodes.getLocale());
		System.out.println(errorcode.isEmpty());
	    System.out.println(errorcode);
		if (errorcode.isEmpty()) {

			errorCodesRepo.save(errorCodes);
			errorcode.add(errorCodes);
		}
		
		return errorcode;
		
	}

	public ArrayList<ErrorCodesEntity> getmsg(String errorMessage) {
		
		return errorCodesRepo.findAllByerrorMessage(errorMessage);
		
	}
	
	public ArrayList<ErrorCodesEntity> getMsByLocale(String errorMessage,String locale) {
		
		
		return errorCodesRepo.finderrorMessageByLocale(errorMessage,locale);
		
	}

}
