package br.com.irrah.bigchatbrasil.domain.usecases.user;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import br.com.irrah.bigchatbrasil.domain.models.UserModel;

public interface CreateUser {
  UserModel exec(UserModel user);
}
