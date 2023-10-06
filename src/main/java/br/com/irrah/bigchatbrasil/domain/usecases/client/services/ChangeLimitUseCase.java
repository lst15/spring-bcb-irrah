package br.com.irrah.bigchatbrasil.domain.usecases.client.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.repositories.ClientRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.client.ChangeLimitClient;

@Service
public class ChangeLimitUseCase implements ChangeLimitClient {

  public final ClientRepository clientRepository;

  @Autowired
  public ChangeLimitUseCase(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public ClientModel exec(String userUuid, Float limit) {
    ClientModel client = validateClientExists(userUuid);

    if (limit < 0) {
      throw new RuntimeException("value not be less than 0");
    }

    client.setAllowConsume(limit);
    clientRepository.save(client);

    return client;
  }

  private ClientModel validateClientExists(String userUuid) {
    Optional<ClientModel> client = clientRepository.findByUserUuid(userUuid);
    if (!client.isPresent()) {
      throw new RuntimeException("Client not exists");
    }
    return client.get();
  }

}
