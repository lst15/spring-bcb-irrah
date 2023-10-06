package br.com.irrah.bigchatbrasil.domain.usecases.messagehasplatform.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.MessageHasPlatformModel;
import br.com.irrah.bigchatbrasil.domain.models.MessageModel;
import br.com.irrah.bigchatbrasil.domain.models.PlatformModel;
import br.com.irrah.bigchatbrasil.domain.repositories.MessageHasPlatformRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.MessageRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.PlatformRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.messagehasplatform.CreateMessageHasPlatform;

@Service
public class CreateMessageHasPlatformUseCase implements CreateMessageHasPlatform {

  public final MessageHasPlatformRepository messageHasPlatformRepository;
  public final PlatformRepository platformRepository;
  public final MessageRepository messageRepository;

  @Autowired
  public CreateMessageHasPlatformUseCase(
      MessageHasPlatformRepository messageHasPlatformRepository,
      PlatformRepository platformRepository,
      MessageRepository messageRepository) {
    this.messageHasPlatformRepository = messageHasPlatformRepository;
    this.messageRepository = messageRepository;
    this.platformRepository = platformRepository;
  }

  // TODO corrigir unicidade
  @Override
  public MessageHasPlatformModel exec(MessageHasPlatformModel messageHasPlatform) {

    Optional<PlatformModel> platformById = platformRepository.findById(messageHasPlatform.getPlatformId());
    Optional<MessageModel> messageById = messageRepository.findById(messageHasPlatform.getMessageId());

    if (!platformById.isPresent() || !messageById.isPresent()) {
      throw new RuntimeException("message or platform not found");
    }

    messageHasPlatformRepository.save(messageHasPlatform);
    return messageHasPlatform;
  }

}
