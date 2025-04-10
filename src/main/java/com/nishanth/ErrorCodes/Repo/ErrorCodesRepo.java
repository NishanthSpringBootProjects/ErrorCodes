package com.nishanth.ErrorCodes.Repo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nishanth.ErrorCodes.Entity.ErrorCodesEntity;

@Repository
public interface ErrorCodesRepo extends JpaRepository<ErrorCodesEntity, Integer> {
	
	
	@Query("SELECT e FROM ErrorCodesEntity e WHERE e.errorMessage = :errormsg AND e.locale = :locale ")
	ArrayList<ErrorCodesEntity> finderrorMessageByLocale(String errormsg,String locale);
	
	ArrayList<ErrorCodesEntity> findAllByerrorMessage(String errormsg);

}
