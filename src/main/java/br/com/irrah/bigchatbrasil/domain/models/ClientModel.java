package br.com.irrah.bigchatbrasil.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client", schema = "public")
public class ClientModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer client_id;

}
