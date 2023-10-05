package br.com.irrah.bigchatbrasil.infra.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.irrah.bigchatbrasil.domain.models.UserModel;
import br.com.irrah.bigchatbrasil.domain.usecases.user.CreateUser;

@RestController
@RequestMapping("/user")
public class UserController {

  private final CreateUser createUser;

  public UserController(CreateUser createUser) {
    this.createUser = createUser;
  }

  @PostMapping
  public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
    createUser.exec(user);
    return new ResponseEntity<UserModel>(user, HttpStatus.CREATED);
  }

}
