package br.com.irrah.bigchatbrasil.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irrah.bigchatbrasil.domain.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {
  Optional<UserModel> findByEmail(String email);

  Optional<UserModel> findByCpf(String cpf);

  Optional<UserModel> findByPhone(String phone);

  Optional<UserModel> findByCompanyCnpj(String companyCnpj);
}
