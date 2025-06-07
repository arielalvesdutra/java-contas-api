package br.com.ariel.api.domain.usecase.conta;

import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.domain.model.conta.CriarContaInput;
import br.com.ariel.api.domain.usecase.conta.mapper.CriarContaMapper;
import br.com.ariel.api.domain.usecase.conta.validator.CriarContaValidador;
import br.com.ariel.api.port.integration.data.PersistirContaPort;
import br.com.ariel.api.port.integration.engine.SolicitacaoValidacaoContaPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CriarContaUseCaseImplTest {

    @InjectMocks
    private CriarContaUseCaseImpl useCase;

    @Spy
    private CriarContaMapper mapper;
    @Mock
    private CriarContaValidador validator;
    @Mock
    private SolicitacaoValidacaoContaPort solicitacaoValidacaoPort;
    @Mock
    private PersistirContaPort persistirContaPort;

    @Test
    void criarConta_comDadosValidos_deveFuncionar() {
        CriarContaInput entrada = CriarContaInput.builder()
                .nome("Maria Rosa")
                .build();

        when(persistirContaPort.persistir(any()))
                .thenReturn(new Conta());

        var resultado = useCase.criarConta(entrada);

        assertThat(resultado).isNotNull();

        verify(validator, times(1)).validate(any());
        verify(mapper, times(1)).toConta(any());
        verify(mapper, times(1)).toOut(any());
        verify(persistirContaPort, times(1)).persistir(any());
        verify(solicitacaoValidacaoPort, times(1)).solicitarValidacaoConta(any());
    }
}
