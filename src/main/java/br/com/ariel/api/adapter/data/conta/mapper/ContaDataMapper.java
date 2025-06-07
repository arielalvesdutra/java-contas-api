package br.com.ariel.api.adapter.data.conta.mapper;

import br.com.ariel.api.adapter.data.conta.entity.ContaEntity;
import br.com.ariel.api.domain.model.conta.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaDataMapper {

    public ContaEntity toEntity(Conta model) {
        return ContaEntity.builder()
                .id(model.getId())
                .nome(model.getNome())
                .aprovada(model.getAprovada())
                .build();
    }

    public Conta toModel(ContaEntity entity) {
        return Conta.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .aprovada(entity.getAprovada())
                .build();
    }

}
