package br.com.irrah.bigchatbrasil.infra.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.usecases.client.AddCreditsClient;
import br.com.irrah.bigchatbrasil.domain.usecases.client.CreateClient;

@RestController
@RequestMapping("/client")
public class ClientController {

  public final CreateClient createClient;
  public final AddCreditsClient addCreditsClient;

  public ClientController(CreateClient createClient, AddCreditsClient addCreditsClient) {
    this.createClient = createClient;
    this.addCreditsClient = addCreditsClient;
  }

  @PutMapping("/credits/{userUuid}")
  public ResponseEntity addCredits(@PathVariable String userUuid, @RequestBody Float credits) {
    try {
      ClientModel client = addCreditsClient.exec(userUuid, credits);
      return new ResponseEntity<ClientModel>(client, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

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
