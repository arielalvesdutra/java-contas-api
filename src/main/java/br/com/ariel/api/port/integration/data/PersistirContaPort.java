package br.com.ariel.api.port.integration.data;

import br.com.ariel.api.domain.model.conta.Conta;

public interface PersistirContaPort {

    Conta persistir(Conta conta);

}
