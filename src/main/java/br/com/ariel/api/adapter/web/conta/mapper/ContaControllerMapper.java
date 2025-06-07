package br.com.ariel.api.adapter.web.conta.mapper;

import br.com.ariel.api.adapter.web.conta.dto.ContaWebOut;
import br.com.ariel.api.adapter.web.conta.dto.CriarContaWebInput;
import br.com.ariel.api.adapter.web.conta.dto.CriarContaWebOutput;
import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.domain.model.conta.CriarContaInput;
import br.com.ariel.api.domain.model.conta.CriarContaOutput;
import org.springframework.stereotype.Component;


@Component
public class ContaControllerMapper {

    public CriarContaInput toModel(CriarContaWebInput input) {
        return CriarContaInput.builder()
                .nome(input.getNome())
                .build();
    }

    public CriarContaWebOutput toDto(CriarContaOutput input) {
        return CriarContaWebOutput.builder()
                .id(input.getId())
                .nome(input.getNome())
                .build();
    }

    public ContaWebOut toDto(Conta input) {
        return ContaWebOut.builder()
                .id(input.getId())
                .nome(input.getNome())
                .aprovada(input.getAprovada())
                .build();
    }

}
