package br.com.irrah.bigchatbrasil.domain.usecases.client.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.repositories.ClientRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.client.CreateClient;

@Service
public class CreateClientUseCase implements CreateClient {

  public final ClientRepository clientRepository;

  @Autowired
  public CreateClientUseCase(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public ClientModel exec(ClientModel client) {
    Optional<ClientModel> findByUserUuid = clientRepository.findByUserUuid(client.getUserUuid());

    if (findByUserUuid.isPresent()) {
      throw new RuntimeException("client already exists");
    }

    clientRepository.save(client);
    return client;
  }

}
