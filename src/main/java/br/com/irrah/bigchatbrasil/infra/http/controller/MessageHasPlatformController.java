package br.com.irrah.bigchatbrasil.infra.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.MessageHasPlatformModel;
import br.com.irrah.bigchatbrasil.domain.usecases.messagehasplatform.CreateMessageHasPlatform;

@RestController
@RequestMapping("/message/platform")
public class MessageHasPlatformController {

  public final CreateMessageHasPlatform createMessageHasPlatform;

  public MessageHasPlatformController(CreateMessageHasPlatform createMessageHasPlatform) {
    this.createMessageHasPlatform = createMessageHasPlatform;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody MessageHasPlatformModel messagePlatform) {

    try {
      createMessageHasPlatform.exec(messagePlatform);
      return new ResponseEntity(messagePlatform, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

}
