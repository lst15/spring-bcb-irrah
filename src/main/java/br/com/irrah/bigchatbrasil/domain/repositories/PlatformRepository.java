package br.com.irrah.bigchatbrasil.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irrah.bigchatbrasil.domain.models.PlatformModel;

public interface PlatformRepository extends JpaRepository<PlatformModel, Integer> {
  Optional<PlatformModel> findByPlatformName(String platformName);
}
