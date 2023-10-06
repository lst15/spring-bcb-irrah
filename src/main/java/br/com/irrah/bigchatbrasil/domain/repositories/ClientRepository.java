package br.com.irrah.bigchatbrasil.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
  Optional<ClientModel> findByUserUuid(String userUuid);
}
