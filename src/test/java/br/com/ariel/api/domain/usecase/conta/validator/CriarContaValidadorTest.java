package br.com.ariel.api.domain.usecase.conta.validator;

import br.com.ariel.api.domain.exception.RegraDeNegocioException;
import br.com.ariel.api.domain.model.conta.CriarContaInput;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CriarContaValidadorTest {


    @InjectMocks
    private CriarContaValidador criarContaValidator;

    @Spy
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    @DisplayName("Validar sem campos obrigatorios deve lancar exception")
    void validate_semCamposObrigatorios_deveLancarException() {
        CriarContaInput entrada = CriarContaInput.builder().build();

        var resultado = assertThrows(RegraDeNegocioException.class,
                () -> criarContaValidator.validate(entrada));

        assertThat(resultado).isNotNull();
        assertThat(resultado.getMessage()).isEqualTo("Entrada invalida para criação de conta");

        verify(validator, times(1)).validate(any(CriarContaInput.class));
    }

    @Test
    @DisplayName("Validar com campos preenchidos deve funcionar")
    void validate_comCamposObrigatorios_deveFuncionar() {
        CriarContaInput entrada = CriarContaInput.builder()
                .nome("Antonio Henrique")
                .build();

        assertDoesNotThrow(() -> criarContaValidator.validate(entrada));

        verify(validator, times(1)).validate(any());
    }

}
