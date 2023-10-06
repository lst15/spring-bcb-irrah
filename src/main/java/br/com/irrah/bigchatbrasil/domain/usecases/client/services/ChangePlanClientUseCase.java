package br.com.irrah.bigchatbrasil.domain.usecases.client.services;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.repositories.ClientRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.client.ChangePlanClient;

public class ChangePlanClientUseCase implements ChangePlanClient {

  public final ClientRepository clientRepository;

  public ChangePlanClientUseCase()

  @Override
  public ClientModel exec(String userUuid, Integer platformId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exec'");
  }

}
