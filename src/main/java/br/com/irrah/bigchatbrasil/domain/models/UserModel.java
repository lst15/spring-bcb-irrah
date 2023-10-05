package br.com.irrah.bigchatbrasil.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name = "user", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@Entity
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String user_uuid;

  @Column(name = "user_cpf")
  private String cpf;

  @Column(name = "user_email")
  private String email;

  @Column(name = "user_name")
  private String name;

  @Column(name = "user_phone")
  private String phone;

  @Column(name = "user_company_cnpj")
  private String company_cnpj;

  @Column(name = "user_company_name")
  private String company_name;

}
