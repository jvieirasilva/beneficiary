package com.beneficiary.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "Documento")
public class Documento {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  
  private String tipoDocumento;
  private String descricao;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataInclusao;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAlteracao;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "beneficiario_id")
  private Beneficiario beneficiario;
  

}