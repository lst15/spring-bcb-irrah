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

@Entity
@Table(name = "client", schema = "public")
@AllArgsConstructor
@Getter
@Setter
public class ClientModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer client_id;

  @Column(name = "user_uuid")
  private String userUuid;

  @Column(name = "plan_id")
  private Integer planId;

  @Column(name = "client_allow_consume")
  private Float allowConsume;

  @Column(name = "client_credits")
  private Float credits;

  @Column(name = "client_current_consume")
  private Float currentConsume;

  public ClientModel() {
  }

}
