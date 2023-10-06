package br.com.irrah.bigchatbrasil.domain.usecases.client;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;

public interface CreateClient {
  ClientModel exec(ClientModel client);
}
