package com.beneficiary.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beneficiary.dto.BeneficiarioDto;
import com.beneficiary.dto.DocumentoDto;
import com.beneficiary.entity.Beneficiario;
import com.beneficiary.entity.Documento;
import com.beneficiary.repository.BeneficiarioRepository;
import com.beneficiary.repository.DocumentoRepository;



@Service
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	public BeneficiarioDto addBeneficiario(BeneficiarioDto beneficiarioDto)  {
		Beneficiario beneficiario = this.getBeneficiario(beneficiarioDto);
		beneficiario.getDocumentos().clear();
		Beneficiario beneficiarioSave = beneficiarioRepository.save(beneficiario);
		List<Documento> docs = this.getBeneficiario(beneficiarioDto).getDocumentos();
		int idDoc = 0;
		for(Documento doc : docs) {
			doc.setBeneficiario(beneficiarioSave);
			beneficiarioDto.setId(beneficiarioSave.getId());
			Documento docRet = documentoRepository.save(doc);
			beneficiarioDto.getDocumentos().get(idDoc).setId(docRet.getId());
			idDoc++;
		}
		return beneficiarioDto;
	}
	
	
	public Page<BeneficiarioDto> getAllBeneficiary(Pageable pageable)  {
		List<Beneficiario> beneficiario = beneficiarioRepository.getAllBeneficiary(pageable) ;
		List<BeneficiarioDto> beneficiarioDtos = getBeneficiaryDto(beneficiario);
		final Page<BeneficiarioDto> pageRet = new PageImpl<>(beneficiarioDtos, pageable,beneficiarioDtos.size());
		return pageRet; 
	}
	
	public void delteBeneficiary(String id)  {
		beneficiarioRepository.deleteById(Long.parseLong(id)); 
	}
	
	Beneficiario getBeneficiario(BeneficiarioDto beneficiarioDto)  {
		  Beneficiario beneficiario = new Beneficiario();
		  beneficiario.setId(beneficiarioDto.getId());
		  if(beneficiarioDto.getId()>0)
			  beneficiario.setDataAlteracao(new Date());
		  
		  if(beneficiarioDto.getId()==0)
			  beneficiario.setDataInclusao(new Date());
		  
		  beneficiario.setNome(beneficiarioDto.getNome());
		  beneficiario.setTelefone(beneficiarioDto.getTelefone());
		  List<Documento> documentos = new ArrayList<Documento>();
		  for(DocumentoDto d : beneficiarioDto.getDocumentos()) {
			  Documento documento = new Documento();
			  documento.setId(d.getId());
			  if(beneficiarioDto.getId()>0)
				  documento.setDataAlteracao(new Date());
			  
			  if(beneficiarioDto.getId()==0)
				  documento.setDataInclusao(new Date());
			  
			  documento.setDescricao(d.getDescricao());
			  documento.setTipoDocumento(d.getTipoDocumento());
			  documento.setDescricao(d.getDescricao());
			  documentos.add(documento);
		  }
		  beneficiario.setDocumentos(documentos);
		  return beneficiario;
	  }
	
	public BeneficiarioDto getBeneficiarioDto(String id) {
		  Beneficiario beneficiario = beneficiarioRepository.getBeneficiaryById(Long.parseLong(id));
		  BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
		  beneficiarioDto.setId(beneficiario.getId());
		  beneficiarioDto.setNome(beneficiario.getNome());
		  beneficiarioDto.setTelefone(beneficiario.getTelefone());
		  List<DocumentoDto> documentos = new ArrayList<DocumentoDto>();
		  for(Documento d : beneficiario.getDocumentos()) {
			  DocumentoDto documentoDto = new DocumentoDto();
			  documentoDto.setId(d.getId());
			  documentoDto.setDescricao(d.getDescricao());
			  documentoDto.setTipoDocumento(d.getTipoDocumento());
			  documentoDto.setDescricao(d.getDescricao());
			  documentos.add(documentoDto);
		  }
		  beneficiarioDto.setDocumentos(documentos);
	      return beneficiarioDto;
	}
	
	public List<BeneficiarioDto> getBeneficiaryDto(List<Beneficiario>  beneficiarios) {
		List<BeneficiarioDto> beneficiarioDtos = new ArrayList<BeneficiarioDto>();
		for (Beneficiario beneficiario : beneficiarios) {
			  Beneficiario bf  = new  Beneficiario();
			  BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
			  beneficiarioDto.setId(beneficiario.getId());
			  beneficiarioDto.setNome(beneficiario.getNome());
			  beneficiarioDto.setTelefone(beneficiario.getTelefone());
			  beneficiarioDtos.add(beneficiarioDto);
		}	  
	    return beneficiarioDtos;
	}

}
