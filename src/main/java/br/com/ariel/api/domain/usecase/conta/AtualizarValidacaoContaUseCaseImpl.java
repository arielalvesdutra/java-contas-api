package br.com.ariel.api.domain.usecase.conta;


import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.domain.conta.AtualizarValidacaoContaUseCase;
import br.com.ariel.api.port.domain.conta.BuscarContaPorIdUseCase;
import br.com.ariel.api.port.integration.data.PersistirContaPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
public class AtualizarValidacaoContaUseCaseImpl implements AtualizarValidacaoContaUseCase {

    private final BuscarContaPorIdUseCase buscarContaPorIdUseCase;
    private final PersistirContaPort persistirContaPort;

    @Override
    public void atualizar(Conta entrada) {
        Conta contaExistente = buscarContaPorIdUseCase.buscarPorId(entrada.getId());
        log.info("Conta {} localizada na base de dados", entrada.getId());

        contaExistente.setAprovada(entrada.getAprovada());
        contaExistente.setDataAlteracao(ZonedDateTime.now());

        persistirContaPort.persistir(contaExistente);

        log.info("Conta persistida com sucesso na base de dado: {}", contaExistente);
    }

}
