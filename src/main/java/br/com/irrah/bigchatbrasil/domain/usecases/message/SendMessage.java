package br.com.irrah.bigchatbrasil.domain.usecases.message;

import br.com.irrah.bigchatbrasil.domain.models.MessageModel;

public interface SendMessage {
  MessageModel exec(MessageModel message, Integer platformId);
}
