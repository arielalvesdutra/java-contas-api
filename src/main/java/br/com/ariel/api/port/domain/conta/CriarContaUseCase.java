package br.com.ariel.api.port.domain.conta;

import br.com.ariel.api.domain.model.conta.CriarContaInput;
import br.com.ariel.api.domain.model.conta.CriarContaOutput;

public interface CriarContaUseCase {

    CriarContaOutput criarConta(CriarContaInput input);
}
