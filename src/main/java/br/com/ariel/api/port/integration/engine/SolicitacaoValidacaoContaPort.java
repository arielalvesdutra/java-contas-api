package br.com.ariel.api.port.integration.engine;

import br.com.ariel.api.domain.model.conta.Conta;


public interface SolicitacaoValidacaoContaPort {


    void solicitarValidacaoConta(Conta input);

}
