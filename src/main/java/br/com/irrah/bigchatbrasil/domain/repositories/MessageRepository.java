package br.com.irrah.bigchatbrasil.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irrah.bigchatbrasil.domain.models.MessageModel;

public interface MessageRepository extends JpaRepository<MessageModel, Integer> {

}
