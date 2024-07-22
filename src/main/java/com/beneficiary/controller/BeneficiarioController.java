package com.beneficiary.controller;


import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beneficiary.dto.BeneficiarioDto;
import com.beneficiary.service.BeneficiarioService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioController {
  @Autowired	
  private BeneficiarioService beneficiarioService;
  
  @Operation(summary = "Get Benefiary by Id", description = "Get Benefiary by Id")
  @GetMapping("/find/{id}")
  public ResponseEntity<BeneficiarioDto> getBeneficiary(@PathVariable("id") String id) {
	  BeneficiarioDto beneficiarioDto = beneficiarioService.getBeneficiarioDto(id);
      return new ResponseEntity<>(beneficiarioDto, OK);
  }
  
  @Operation(summary = "Creates Benefiary", description = "Creates Benefiary")
  @PostMapping("/add")
  public ResponseEntity<BeneficiarioDto> addBeneficiary(@RequestBody  @Valid final BeneficiarioDto beneficiarioDto)  {
	  
	  BeneficiarioDto beneficiarioDtoRet = beneficiarioService.addBeneficiario(beneficiarioDto);
      return new ResponseEntity<>(beneficiarioDtoRet, OK);
  }
  @Operation(summary = "Get Documents from Benefiary by Id", description = "Get Documents from Benefiary by Id")
  @GetMapping("/document/{id}")
  public ResponseEntity<?> getDocumentById(@PathVariable("id") String id) {
	  BeneficiarioDto beneficiarioDto = beneficiarioService.getBeneficiarioDto(id);
      return new ResponseEntity<>(beneficiarioDto.getDocumentos(), OK);
  }
  
  
  @Operation(summary = "Get All Benefiarys", description = "Get All Benefiarys")
  @GetMapping("/All")
  public ResponseEntity<?> getAllBenefiarys(@RequestParam(name = "page") Integer page,
  					  @RequestParam(value = "size") Integer size) {
  					 Pageable pagingSort =  PageRequest.of(page, size);
  	 return new ResponseEntity<>(beneficiarioService.getAllBeneficiary(pagingSort), HttpStatus.OK);
  }
  
  @Operation(summary = "Update Benefiary", description = "Update Benefiary")
  @PutMapping("/update")
  public ResponseEntity<BeneficiarioDto> updateBeneficiary(@RequestBody  @Valid final BeneficiarioDto beneficiarioDto)  {
	  
	  BeneficiarioDto beneficiarioDtoRet = beneficiarioService.addBeneficiario(beneficiarioDto);
      return new ResponseEntity<>(beneficiarioDtoRet, OK);
  }
  
  @Operation(summary = "Delete Benefiary", description = "Delete Benefiary")
  @DeleteMapping("/delete")
  public ResponseEntity<?> deteleBeneficiary(@RequestParam(name = "id") String id)  {
	  beneficiarioService.delteBeneficiary(id);
      return new ResponseEntity<>("Deleted", OK);
  }
  
  
  
}