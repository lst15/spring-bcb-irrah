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
@Table(name = "Message", schema = "public")
@Getter
@Setter
@AllArgsConstructor
public class MessageModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer messageId;

  @Column(name = "message_text")
  private String messageText;

  @Column(name = "message_to")
  private String messageTo;

  @Column(name = "user_uuid")
  private String userUuid;

  public MessageModel() {
  }

}
