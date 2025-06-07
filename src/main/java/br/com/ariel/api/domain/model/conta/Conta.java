package br.com.ariel.api.domain.model.conta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

    private UUID id;
    private String nome;
    private Boolean aprovada;

    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAlteracao;

}
