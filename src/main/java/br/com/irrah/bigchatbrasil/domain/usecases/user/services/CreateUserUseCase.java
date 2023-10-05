package br.com.irrah.bigchatbrasil.domain.usecases.user.services;

import java.util.Optional;

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

  // TODO reduzir: ciclos | consultas
  @Override
  public UserModel exec(UserModel user) {
    Optional<UserModel> userByEmail = userRepository.findByEmail(user.getEmail());
    Optional<UserModel> userByCpf = userRepository.findByCpf(user.getCpf());
    Optional<UserModel> userByPhone = userRepository.findByPhone(user.getPhone());
    Optional<UserModel> userByCompanyCnpj = userRepository.findByCompanyCnpj(user.getCompanyCnpj());

    if (userByEmail.isPresent() ||
        userByCpf.isPresent() ||
        userByPhone.isPresent() ||
        userByCompanyCnpj.isPresent()) {
      throw new RuntimeException("user already exists");
    }

    userRepository.save(user);
    return user;
  }

}
