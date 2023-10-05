package br.com.irrah.bigchatbrasil.domain.usecases.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.UserModel;
import br.com.irrah.bigchatbrasil.domain.repositories.UserRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.user.CreateUser;

@Service
public class CreateUserUseCase implements CreateUser {

  private final UserRepository userRepository;

  @Autowired
  public CreateUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserModel exec(UserModel user) {

    userRepository.save(user);
    return user;
  }

}
