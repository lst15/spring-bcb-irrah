package br.com.irrah.bigchatbrasil.domain.usecases.messagehasplatform;

import br.com.irrah.bigchatbrasil.domain.models.MessageHasPlatformModel;

public interface CreateMessageHasPlatform {
  MessageHasPlatformModel exec(MessageHasPlatformModel messageHasPlatform);
}
