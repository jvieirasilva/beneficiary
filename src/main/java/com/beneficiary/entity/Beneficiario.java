package com.beneficiary.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "Beneficiario")
public class Beneficiario {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
   
  private String nome;
  
  private String telefone;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataInclusao;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAlteracao;
  
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="beneficiario")
  private List<Documento> documentos = new ArrayList<Documento>();
  
  
  
  
  
}