package br.com.irrah.bigchatbrasil.infra.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.MessageModel;
import br.com.irrah.bigchatbrasil.domain.usecases.message.CreateMessage;
import br.com.irrah.bigchatbrasil.domain.usecases.message.SendMessage;

@RestController
@RequestMapping("/message")
public class MessageController {

  public final CreateMessage createMessage;
  public final SendMessage sendMessage;

  public MessageController(CreateMessage createMessage, SendMessage sendMessage) {
    this.createMessage = createMessage;
    this.sendMessage = sendMessage;
  }

  @PostMapping("/send/{platformId}")
  public ResponseEntity send(@PathVariable Integer platformId, @RequestBody MessageModel message) {
    System.out.println(message);

    try {
      sendMessage.exec(message, platformId);
      return new ResponseEntity<MessageModel>(message, HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

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
