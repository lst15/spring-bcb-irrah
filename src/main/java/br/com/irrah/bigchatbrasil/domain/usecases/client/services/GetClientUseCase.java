package br.com.irrah.bigchatbrasil.domain.usecases.client.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.repositories.ClientRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.client.GetClient;

@Service
public class GetClientUseCase implements GetClient {

  public final ClientRepository clientRepository;

  @Autowired
  public GetClientUseCase(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Optional<ClientModel> exec(String userUuid) {
    Optional<ClientModel> client = clientRepository.findByUserUuid(userUuid);

    if (!client.isPresent()) {
      throw new RuntimeException("Client not exists");
    }

    return client;
  }

}
