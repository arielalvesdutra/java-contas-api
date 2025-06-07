package br.com.ariel.api.adapter.web.conta.dto;


import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "data")
public class CriarContaWebOutput {

    private UUID id;
    private String nome;

}
