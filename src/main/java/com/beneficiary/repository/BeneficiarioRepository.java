package com.beneficiary.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beneficiary.entity.Beneficiario;


@Repository
public interface BeneficiarioRepository extends  JpaRepository<Beneficiario, Long>{
	
	
	 @Query("SELECT p FROM Beneficiario p " +
	    		"JOIN FETCH p.documentos " +
	             "WHERE p.id = ?1 ")
	    Beneficiario getBeneficiaryById(Long id);	  
	 
	 
	 @Query("select p from Beneficiario p  " )
	 List<Beneficiario> getAllBeneficiary(Pageable pageable);		

	
	
	
	

}
