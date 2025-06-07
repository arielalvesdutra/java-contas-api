package br.com.ariel.api.adapter.kafka.conta.producer;


import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.integration.engine.SolicitacaoValidacaoContaPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;



@Slf4j
@Component
@RequiredArgsConstructor
public class SolicitacaoValidacaoContaProducer implements SolicitacaoValidacaoContaPort {

    private static final String TOPICO_SOLICITACAO_VALIDACAO_CONTA = "solicitacao-validacao-conta";

    private final KafkaTemplate<String, Conta> kafkaTemplate;

    @Override
    public void solicitarValidacaoConta(Conta entrada) {

        log.info("Enviando requisição de validação da conta {} para o tópico {}",
                entrada.getId(),
                TOPICO_SOLICITACAO_VALIDACAO_CONTA);

        kafkaTemplate.send(TOPICO_SOLICITACAO_VALIDACAO_CONTA, entrada);

        log.info("Requisição de validação enviada para a conta {} para o topico {}",
                entrada.getId(),
                TOPICO_SOLICITACAO_VALIDACAO_CONTA);
    }

}
