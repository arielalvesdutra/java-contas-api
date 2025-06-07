package br.com.ariel.api.domain.usecase.conta.mapper;

import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.domain.model.conta.CriarContaInput;
import br.com.ariel.api.domain.model.conta.CriarContaOutput;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class CriarContaMapper {

    public Conta toConta(CriarContaInput input) {
        return Conta.builder()
                .nome(input.getNome())
                .dataCriacao(ZonedDateTime.now())
                .build();
    }

    public CriarContaOutput toOut(Conta conta) {
        return CriarContaOutput.builder()
                .id(conta.getId())
                .nome(conta.getNome())
                .build();
    }

}
