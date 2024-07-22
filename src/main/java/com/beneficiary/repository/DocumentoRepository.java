package com.beneficiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beneficiary.entity.Documento;


@Repository
public interface DocumentoRepository extends  JpaRepository<Documento, Long>{
	
	 @Query("SELECT p FROM Documento p " +
			     "JOIN FETCH p.beneficiario " +
	             "WHERE p.beneficiario.id=1")
	 List<Documento> getPedidoById();	

}
