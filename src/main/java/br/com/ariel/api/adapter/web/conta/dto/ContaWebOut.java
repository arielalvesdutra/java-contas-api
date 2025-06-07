package br.com.ariel.api.adapter.web.conta.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContaWebOut {

    private UUID id;
    private String nome;
    private Boolean aprovada;

}
