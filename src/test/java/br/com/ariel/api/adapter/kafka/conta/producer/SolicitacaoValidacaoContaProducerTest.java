package br.com.ariel.api.adapter.kafka.conta.producer;

import br.com.ariel.api.domain.model.conta.Conta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SolicitacaoValidacaoContaProducerTest {

    @InjectMocks
    private SolicitacaoValidacaoContaProducer producer;

    @Mock
    private KafkaTemplate<String, Conta> kafkaTemplate;

    @Test
    @DisplayName("Solicitar validação de conta via Kafka deve funcionar")
    void solicitarValidacaoConta_deveFuncionar() {
        Conta entrada = Conta.builder()
                .id(UUID.fromString("94b704ab-4f9f-4d6a-9c86-b299e6b40e32"))
                .nome("Maria Betania")
                .build();

        producer.solicitarValidacaoConta(entrada);

        verify(kafkaTemplate, times(1)).send(anyString(), any(Conta.class));
    }
}
