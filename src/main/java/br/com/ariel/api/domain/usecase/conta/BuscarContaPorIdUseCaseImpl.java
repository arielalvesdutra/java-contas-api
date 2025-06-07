package br.com.ariel.api.domain.usecase.conta;

import br.com.ariel.api.domain.exception.RegraDeNegocioException;
import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.domain.conta.BuscarContaPorIdUseCase;
import br.com.ariel.api.port.integration.data.BuscarContaPorIdPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuscarContaPorIdUseCaseImpl implements BuscarContaPorIdUseCase {

    private final BuscarContaPorIdPort buscarContaPort;

    @Override
    public Conta buscarPorId(UUID contaId) {
        var contaOptional = buscarContaPort.buscarPorId(contaId);

        if (contaOptional.isEmpty()) {
            throw new RegraDeNegocioException(String.format("Conta de id %s não cadastrada", contaId));
        }
        
        return contaOptional.get();
    }

}
