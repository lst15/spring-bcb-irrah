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
@Table(name = "message_has_platform")
@AllArgsConstructor
@Getter
@Setter
public class MessageHasPlatformModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer messageHasPlatformId;

  @Column(name = "platform_id")
  private Integer platformId;

  @Column(name = "message_id")
  private Integer messageId;

  public MessageHasPlatformModel() {
  }

}
