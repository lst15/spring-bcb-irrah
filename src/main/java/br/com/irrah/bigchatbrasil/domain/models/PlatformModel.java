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
@Table(name = "platform", schema = "public")
@Getter
@Setter
@AllArgsConstructor
public class PlatformModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer platform_id;

  @Column(name = "platform_name")
  private String platformName;

  @Column(name = "platform_cost")
  private Float platformCost;

  public PlatformModel() {
  }

}
