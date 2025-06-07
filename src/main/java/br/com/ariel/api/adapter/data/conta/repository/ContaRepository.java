package br.com.ariel.api.adapter.data.conta.repository;

import br.com.ariel.api.adapter.data.conta.entity.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<ContaEntity, UUID> {

}
