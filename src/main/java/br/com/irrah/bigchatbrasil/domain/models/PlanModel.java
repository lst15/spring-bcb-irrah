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
@Table(name = "plan", schema = "public")
@Getter
@Setter
@AllArgsConstructor
public class PlanModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer plan_id;

  @Column(name = "plan_name")
  private String planName;

  public PlanModel() {
  }

}
