package br.com.ariel.api.adapter.web.conta;

import br.com.ariel.api.adapter.web.conta.mapper.ContaControllerMapper;
import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.domain.conta.BuscarContaPorIdUseCase;
import br.com.ariel.api.port.domain.conta.CriarContaUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ContaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoSpyBean
    private ContaControllerMapper mapper;
    @MockitoBean
    private CriarContaUseCase criarContaUseCase;
    @MockitoBean
    private BuscarContaPorIdUseCase buscarContaPorIdUseCase;

    @Test
    @DisplayName("Buscar conta no endpoint de conta por id deve funcionar")
    void buscarContaPorId_deveFuncionar() throws Exception {
        when(buscarContaPorIdUseCase.buscarPorId(any()))
                .thenReturn(new Conta());

        mockMvc.perform(MockMvcRequestBuilders.get("/contas/94b704ab-4f9f-4d6a-9c86-b299e6b40e32")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(buscarContaPorIdUseCase, times(1)).buscarPorId(any());
        verify(mapper, times(1)).toDto(any(Conta.class));
    }

}
