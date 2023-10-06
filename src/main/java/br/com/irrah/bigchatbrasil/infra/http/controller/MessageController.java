package br.com.irrah.bigchatbrasil.infra.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.MessageModel;
import br.com.irrah.bigchatbrasil.domain.usecases.message.CreateMessage;

@RestController
@RequestMapping("/message")
public class MessageController {

  public final CreateMessage createMessage;

  public MessageController(CreateMessage createMessage) {
    this.createMessage = createMessage;
  }

  @PostMapping
  public ResponseEntity<MessageModel> create(@RequestBody MessageModel message) {

    try {
      createMessage.exec(message);
      return new ResponseEntity<MessageModel>(message, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

}
