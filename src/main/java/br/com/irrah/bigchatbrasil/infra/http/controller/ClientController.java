package br.com.irrah.bigchatbrasil.infra.http.controller;

import java.util.Optional;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.usecases.client.AddCreditsClient;
import br.com.irrah.bigchatbrasil.domain.usecases.client.ChangeLimitClient;
import br.com.irrah.bigchatbrasil.domain.usecases.client.ChangePlanClient;
import br.com.irrah.bigchatbrasil.domain.usecases.client.CreateClient;
import br.com.irrah.bigchatbrasil.domain.usecases.client.GetClient;

@RestController
@RequestMapping("/client")
public class ClientController {

  public final CreateClient createClient;
  public final AddCreditsClient addCreditsClient;
  public final GetClient getClient;
  public final ChangeLimitClient changeLimitClient;
  public final ChangePlanClient changePlanClient;

  public ClientController(
      CreateClient createClient,
      AddCreditsClient addCreditsClient,
      GetClient getClient,
      ChangeLimitClient changeLimitClient,
      ChangePlanClient changePlanClient) {
    this.createClient = createClient;
    this.addCreditsClient = addCreditsClient;
    this.getClient = getClient;
    this.changeLimitClient = changeLimitClient;
    this.changePlanClient = changePlanClient;
  }

  @GetMapping("/{userUuid}")
  public ResponseEntity getClient(@PathVariable String userUuid) {
    try {
      Optional<ClientModel> clientModel = getClient.exec(userUuid);
      return new ResponseEntity(clientModel, HttpStatus.FOUND);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/limit/{userUuid}")
  public ResponseEntity changeLimit(@PathVariable String userUuid, @RequestBody Float limit) {
    try {
      ClientModel client = changeLimitClient.exec(userUuid, limit);
      return new ResponseEntity<ClientModel>(client, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
  }

  @PutMapping("/plan/{userUuid}")
  public ResponseEntity changePlan(@PathVariable String userUuid, @RequestBody Integer planId) {
    try {
      ClientModel client = changePlanClient.exec(userUuid, planId);
      return new ResponseEntity<ClientModel>(client, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
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
