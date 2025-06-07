package br.com.ariel.api.domain.usecase.conta;


import br.com.ariel.api.domain.model.conta.CriarContaInput;
import br.com.ariel.api.domain.model.conta.CriarContaOutput;
import br.com.ariel.api.domain.usecase.conta.mapper.CriarContaMapper;
import br.com.ariel.api.domain.usecase.conta.validator.CriarContaValidador;
import br.com.ariel.api.port.domain.conta.CriarContaUseCase;
import br.com.ariel.api.port.integration.data.PersistirContaPort;
import br.com.ariel.api.port.integration.engine.SolicitacaoValidacaoContaPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriarContaUseCaseImpl implements CriarContaUseCase {

    private final CriarContaMapper mapper;
    private final CriarContaValidador validator;
    private final SolicitacaoValidacaoContaPort solicitacaoValidacaoPort;
    private final PersistirContaPort persistirContaPort;

    @Override
    public CriarContaOutput criarConta(CriarContaInput entrada) {
        validator.validate(entrada);

        log.info("Criando conta para o nome {}", entrada.getNome());
        var contaSalva = persistirContaPort.persistir(mapper.toConta(entrada));

        log.info("Solicitando validacao da conta {}", contaSalva.getId());
        solicitacaoValidacaoPort.solicitarValidacaoConta(contaSalva);
        log.info("Solitação de validacao para conta {} enviada", contaSalva.getId());

        return mapper.toOut(contaSalva);
    }
}
