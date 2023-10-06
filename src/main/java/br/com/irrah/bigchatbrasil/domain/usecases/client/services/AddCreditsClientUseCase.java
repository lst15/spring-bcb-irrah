package br.com.irrah.bigchatbrasil.domain.usecases.client.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.repositories.ClientRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.client.AddCreditsClient;

@Service
public class AddCreditsClientUseCase implements AddCreditsClient {

  public final ClientRepository clientRepository;

  @Autowired
  public AddCreditsClientUseCase(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public ClientModel exec(String userUuid, Float credits) {

    ClientModel client = validateClientExists(userUuid);

    client.setCredits(client.getCredits() + credits);
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
