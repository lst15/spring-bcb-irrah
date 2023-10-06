package br.com.irrah.bigchatbrasil.domain.usecases.client.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.ClientModel;
import br.com.irrah.bigchatbrasil.domain.models.PlanModel;
import br.com.irrah.bigchatbrasil.domain.repositories.ClientRepository;
import br.com.irrah.bigchatbrasil.domain.repositories.PlanRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.client.ChangePlanClient;

@Service
public class ChangePlanClientUseCase implements ChangePlanClient {

  public final ClientRepository clientRepository;
  public final PlanRepository planRepository;

  @Autowired
  public ChangePlanClientUseCase(
      ClientRepository clientRepository,
      PlanRepository planRepository) {
    this.clientRepository = clientRepository;
    this.planRepository = planRepository;
  }

  @Override
  public ClientModel exec(String userUuid, Integer planId) {
    ClientModel client = validateClientExists(userUuid);
    validatePlanExists(planId);

    client.setPlanId(planId);
    clientRepository.save(client);

    return client;
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
