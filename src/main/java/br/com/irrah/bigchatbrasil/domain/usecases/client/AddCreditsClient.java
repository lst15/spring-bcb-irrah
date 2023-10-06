package br.com.irrah.bigchatbrasil.domain.usecases.client;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;

public interface AddCreditsClient {
  ClientModel exec(String userUuid, Float credits);
}
