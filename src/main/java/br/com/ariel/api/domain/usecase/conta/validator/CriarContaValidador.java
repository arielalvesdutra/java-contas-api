package br.com.ariel.api.domain.usecase.conta.validator;

import br.com.ariel.api.domain.exception.RegraDeNegocioException;
import br.com.ariel.api.domain.model.conta.CriarContaInput;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class CriarContaValidador {

    private final Validator validator;

    public void validate(CriarContaInput entrada) {
        final var resultadoValidacao = validator.validate(entrada);

        if (temErrosEncontrados(resultadoValidacao)) {
            var erros = resultadoValidacao.stream().map(ConstraintViolation::getMessage).toList();
            log.error("Dados invalidos para criação de conta. Erros encontrados: {}", erros);
            throw new RegraDeNegocioException("Entrada invalida para criação de conta");
        }
    }

    private static boolean temErrosEncontrados(Set<ConstraintViolation<CriarContaInput>> resultadoValidacao) {
        return Boolean.FALSE.equals(resultadoValidacao.isEmpty());
    }
}
