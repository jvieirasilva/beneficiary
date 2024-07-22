package com.beneficiary.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class BeneficiarioDto implements Serializable {
  private long id;
  private String nome;
  private String telefone;
  public List<DocumentoDto> documentos = new ArrayList<DocumentoDto>();
}