package br.com.irrah.bigchatbrasil.domain.usecases.message.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.MessageModel;
import br.com.irrah.bigchatbrasil.domain.models.UserModel;
import br.com.irrah.bigchatbrasil.domain.repositories.MessageRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.UserRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.message.CreateMessage;

@Service
public class CreateMessageUseCase implements CreateMessage {

  public final MessageRepository messageRepository;
  public final UserRepository userRepository;

  @Autowired
  public CreateMessageUseCase(
      MessageRepository messageRepository,
      UserRepository userRepository) {
    this.messageRepository = messageRepository;
    this.userRepository = userRepository;
  }

  @Override
  public MessageModel exec(MessageModel message) {
    Optional<UserModel> findByUuid = userRepository.findById(message.getUserUuid());

    if (!findByUuid.isPresent()) {
      throw new RuntimeException("user not found");
    }

    messageRepository.save(message);
    return message;
  }

}
