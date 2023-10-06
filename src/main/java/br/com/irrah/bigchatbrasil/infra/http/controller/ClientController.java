package br.com.irrah.bigchatbrasil.infra.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.usecases.client.CreateClient;

@RestController
@RequestMapping("/client")
public class ClientController {

  public final CreateClient createClient;

  public ClientController(CreateClient createClient) {
    this.createClient = createClient;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody ClientModel client) {
    try {
      createClient.exec(client);
      return new ResponseEntity(client, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

}
