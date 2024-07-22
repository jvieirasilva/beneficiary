package com.beneficiary.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DocumentoDto implements Serializable{

  private long id;
  private String tipoDocumento;
  private String descricao;
 

}