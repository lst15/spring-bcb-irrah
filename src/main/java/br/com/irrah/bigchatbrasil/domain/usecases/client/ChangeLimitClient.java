package br.com.irrah.bigchatbrasil.domain.usecases.client;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;

public interface ChangeLimitClient {
  ClientModel exec(String userUuid, Float limit);
}
