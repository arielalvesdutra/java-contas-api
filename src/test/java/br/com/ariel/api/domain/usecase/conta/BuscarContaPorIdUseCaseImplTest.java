package br.com.ariel.api.domain.usecase.conta;

import br.com.ariel.api.domain.exception.RegraDeNegocioException;
import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.integration.data.BuscarContaPorIdPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuscarContaPorIdUseCaseImplTest {

    @InjectMocks
    private BuscarContaPorIdUseCaseImpl useCase;

    @Mock
    private BuscarContaPorIdPort buscarContaPort;

    @Test
    @DisplayName("Buscar conta por id sem conta existente deve lançar exception")
    void buscarPorId_semContaExistente_deveLancarException() {

        UUID contaId = UUID.fromString("94b704ab-4f9f-4d6a-9c86-b299e6b40e32");

        var resultado = assertThrows(RegraDeNegocioException.class,
                () -> useCase.buscarPorId(contaId));

        assertThat(resultado).isNotNull();
        assertThat(resultado.getMessage()).isEqualTo("Conta de id 94b704ab-4f9f-4d6a-9c86-b299e6b40e32 não cadastrada");

        verify(buscarContaPort, times(1)).buscarPorId(any());
    }

    @Test
    @DisplayName("Buscar conta por id com conta existente deve funcionar")
    void buscarPorId_comContaExistente_deveFuncionar() {
        UUID contaId = UUID.fromString("94b704ab-4f9f-4d6a-9c86-b299e6b40e32");

        when(buscarContaPort.buscarPorId(any()))
                .thenReturn(Optional.of(new Conta()));

        var resultado = useCase.buscarPorId(contaId);

        assertThat(resultado).isNotNull();

        verify(buscarContaPort, times(1)).buscarPorId(any());
    }

}
