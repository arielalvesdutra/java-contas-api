package br.com.ariel.api.port.integration.data;

import br.com.ariel.api.domain.model.conta.Conta;

import java.util.Optional;
import java.util.UUID;

public interface BuscarContaPorIdPort {

    Optional<Conta> buscarPorId(UUID id);

}
