package br.com.irrah.bigchatbrasil.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irrah.bigchatbrasil.domain.models.PlanModel;

public interface PlanRepository extends JpaRepository<PlanModel, Integer> {
  Optional<PlanModel> findByPlanName(String planName);
}
