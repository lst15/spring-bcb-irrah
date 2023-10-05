package br.com.irrah.bigchatbrasil.domain.usecases.plan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.PlanModel;
import br.com.irrah.bigchatbrasil.domain.repositories.PlanRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.plan.CreatePlan;

@Service
public class CreatePlanUseCase implements CreatePlan {

  public final PlanRepository planRepository;

  @Autowired
  public CreatePlanUseCase(PlanRepository planRepository) {
    this.planRepository = planRepository;
  }

  @Override
  public PlanModel exec(PlanModel plan) {
    Optional<PlanModel> findPlanByName = planRepository.findByPlanName(plan.getPlanName());

    if (findPlanByName.isPresent()) {
      throw new RuntimeException("plan already exists");
    }
    planRepository.save(plan);
    return plan;
  }

}