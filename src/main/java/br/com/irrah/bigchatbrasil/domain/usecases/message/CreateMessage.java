package br.com.irrah.bigchatbrasil.domain.usecases.message;

import br.com.irrah.bigchatbrasil.domain.models.MessageModel;

public interface CreateMessage {
  MessageModel exec(MessageModel message);
}
