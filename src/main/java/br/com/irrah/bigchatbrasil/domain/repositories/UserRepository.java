package br.com.irrah.bigchatbrasil.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irrah.bigchatbrasil.domain.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
