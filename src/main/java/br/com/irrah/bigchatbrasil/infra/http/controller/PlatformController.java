package br.com.irrah.bigchatbrasil.infra.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.PlatformModel;
import br.com.irrah.bigchatbrasil.domain.usecases.platform.CreatePlatform;

@RestController
@RequestMapping("/platform")
public class PlatformController {

  public final CreatePlatform createPlatform;

  public PlatformController(CreatePlatform createPlatform) {
    this.createPlatform = createPlatform;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody PlatformModel platform) {

    try {
      createPlatform.exec(platform);
      return new ResponseEntity(platform, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

  }

}
