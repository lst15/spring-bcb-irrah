package br.com.irrah.bigchatbrasil.domain.usecases.plan;

import br.com.irrah.bigchatbrasil.domain.models.PlanModel;

public interface CreatePlan {
  PlanModel exec(PlanModel plan);
}
