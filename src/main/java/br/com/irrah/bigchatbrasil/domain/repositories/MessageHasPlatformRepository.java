package br.com.irrah.bigchatbrasil.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irrah.bigchatbrasil.domain.models.MessageHasPlatformModel;

public interface MessageHasPlatformRepository extends JpaRepository<MessageHasPlatformModel, Integer> {

}
