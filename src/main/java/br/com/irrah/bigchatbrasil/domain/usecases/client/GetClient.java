package br.com.irrah.bigchatbrasil.domain.usecases.client;

import java.util.Optional;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;

public interface GetClient {
  Optional<ClientModel> exec(String userUuid);
}
