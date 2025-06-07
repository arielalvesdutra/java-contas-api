package br.com.ariel.api.domain.usecase.conta;

import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.domain.conta.BuscarContaPorIdUseCase;
import br.com.ariel.api.port.integration.data.PersistirContaPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarValidacaoContaUseCaseImplTest {

    @InjectMocks
    private AtualizarValidacaoContaUseCaseImpl useCase;

    @Mock
    private BuscarContaPorIdUseCase buscarContaPorIdUseCase;
    @Mock
    private PersistirContaPort persistirContaPort;

    @Test
    @DisplayName("Atualizar validação de conta com dados validos deve funcionar")
    void atualizar_comDadosValidos_deveFuncionar() {
        UUID contaId = UUID.fromString("94b704ab-4f9f-4d6a-9c86-b299e6b40e32");
        Conta entrada = Conta.builder()
                .id(contaId)
                .nome("Jose Antonio")
                .aprovada(Boolean.TRUE)
                .build();
        Conta contaPreSalva = Conta.builder()
                .id(contaId)
                .nome("Jose Antonio")
                .build();
        when(buscarContaPorIdUseCase.buscarPorId(eq(contaId)))
                .thenReturn(contaPreSalva);

        useCase.atualizar(entrada);

        verify(buscarContaPorIdUseCase, times(1)).buscarPorId(any());
        verify(persistirContaPort, times(1)).persistir(any());

    }
}
