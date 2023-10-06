package br.com.irrah.bigchatbrasil.domain.usecases.message.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.models.MessageModel;
import br.com.irrah.bigchatbrasil.domain.models.PlanModel;
import br.com.irrah.bigchatbrasil.domain.models.PlatformModel;
import br.com.irrah.bigchatbrasil.domain.models.UserModel;
import br.com.irrah.bigchatbrasil.domain.repositories.ClientRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.MessageHasPlatformRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.MessageRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.PlanRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.PlatformRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.UserRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.message.SendMessage;

@Service
public class SendMessageUseCase implements SendMessage {

  private final MessageRepository messageRepository;
  private final ClientRepository clientRepository;
  private final MessageHasPlatformRepository messageHasPlatformRepository;
  private final PlatformRepository platformRepository;
  private final PlanRepository planRepository;

  @Autowired
  public SendMessageUseCase(
      MessageRepository messageRepository,
      ClientRepository clientRepository,
      UserRepository userRepository,
      MessageHasPlatformRepository messageHasPlatformRepository,
      PlatformRepository platformRepository,
      PlanRepository planRepository) {
    this.messageRepository = messageRepository;
    this.clientRepository = clientRepository;
    this.messageHasPlatformRepository = messageHasPlatformRepository;
    this.platformRepository = platformRepository;
    this.planRepository = planRepository;
  }

  @Override
  public MessageModel exec(MessageModel message, Integer platformId) {
    PlatformModel platform = validatePlatformExists(platformId);
    ClientModel client = validateClientExists(message.getUserUuid());
    PlanModel plan = validatePlanExists(client.getPlanId());

    String planName = plan.getPlanName();
    Float platformCost = platform.getPlatformCost();

    if ("pre-pago".equals(planName)) {
      if (client.getCredits() < platformRepository.findById(platformId).get().getPlatformCost()) {
        throw new RuntimeException("Not enough balance");
      }

      client.setCredits(client.getCredits() - platformCost);
    } else if ("pos-pago".equals(planName)) {
      if (client.getCurrentConsume() >= client.getAllowConsume()) {
        throw new RuntimeException("Not enough balance");
      }

      client.setCurrentConsume(client.getCurrentConsume() + platformCost);
    } else {
      throw new RuntimeException("Plan not allowed");
    }

    messageRepository.save(message);
    // MessageHasPlatformModel messagePlatform = new MessageHasPlatformModel(null,
    // platformId, message.getMessageId());
    // messageHasPlatformRepository.save(messagePlatform);
    return message;
  }

  private PlatformModel validatePlatformExists(Integer platformId) {
    Optional<PlatformModel> platform = platformRepository.findById(platformId);
    if (!platform.isPresent()) {
      throw new RuntimeException("Platform not exists");
    }
    return platform.get();
  }

  private ClientModel validateClientExists(String userUuid) {
    Optional<ClientModel> client = clientRepository.findByUserUuid(userUuid);
    if (!client.isPresent()) {
      throw new RuntimeException("Client not exists");
    }
    return client.get();
  }

  private PlanModel validatePlanExists(Integer planId) {
    Optional<PlanModel> plan = planRepository.findById(planId);
    if (!plan.isPresent()) {
      throw new RuntimeException("Plan not exists");
    }
    return plan.get();
  }
}
