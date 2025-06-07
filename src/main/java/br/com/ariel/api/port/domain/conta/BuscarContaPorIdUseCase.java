package br.com.ariel.api.port.domain.conta;

import br.com.ariel.api.domain.model.conta.Conta;

import java.util.UUID;

public interface BuscarContaPorIdUseCase {

    Conta buscarPorId(UUID id);

}
