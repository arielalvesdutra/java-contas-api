package br.com.ariel.api.adapter.kafka.conta.consumer;

import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.domain.conta.AtualizarValidacaoContaUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RespostaValidacaoContaConsumer {

    private static final String TOPICO_RESPOSTA_VALIDACAO_CONTA = "resposta-validacao-conta";

    private final AtualizarValidacaoContaUseCase atualizarValidacaoContaUseCase;

    @KafkaListener(topics = TOPICO_RESPOSTA_VALIDACAO_CONTA, groupId = "api")
    public void consumer(Conta entrada) {

        log.info("Consumindo tópico {} com entrada: {}",
                TOPICO_RESPOSTA_VALIDACAO_CONTA,
                entrada);

        atualizarValidacaoContaUseCase.atualizar(entrada);

        log.info("Consumido tópico {} com entrada: {}",
                TOPICO_RESPOSTA_VALIDACAO_CONTA,
                entrada);
    }

}
