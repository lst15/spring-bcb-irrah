package br.com.irrah.bigchatbrasil.domain.usecases.platform;

import br.com.irrah.bigchatbrasil.domain.models.PlatformModel;

public interface CreatePlatform {
  PlatformModel exec(PlatformModel platform);
}
