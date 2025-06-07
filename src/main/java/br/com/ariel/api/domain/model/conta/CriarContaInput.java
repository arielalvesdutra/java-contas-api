package br.com.ariel.api.domain.model.conta;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarContaInput {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

}
