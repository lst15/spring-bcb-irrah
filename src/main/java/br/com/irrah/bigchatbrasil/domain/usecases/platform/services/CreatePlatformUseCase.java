package br.com.irrah.bigchatbrasil.domain.usecases.platform.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irrah.bigchatbrasil.domain.models.PlatformModel;
import br.com.irrah.bigchatbrasil.domain.repositories.PlatformRepository;
import br.com.irrah.bigchatbrasil.domain.usecases.platform.CreatePlatform;

@Service
public class CreatePlatformUseCase implements CreatePlatform {

  public final PlatformRepository platformRepository;

  @Autowired
  public CreatePlatformUseCase(PlatformRepository platformRepository) {
    this.platformRepository = platformRepository;
  }

  @Override
  public PlatformModel exec(PlatformModel platform) {
    Optional<PlatformModel> findByPlatformName = platformRepository.findByPlatformName(platform.getPlatformName());

    if (findByPlatformName.isPresent()) {
      throw new RuntimeException("platform already exists");
    }

    platformRepository.save(platform);
    return platform;
  }

}
