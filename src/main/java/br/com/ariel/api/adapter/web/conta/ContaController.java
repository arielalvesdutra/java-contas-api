package br.com.ariel.api.adapter.web.conta;

import br.com.ariel.api.adapter.web.conta.dto.ContaWebOut;
import br.com.ariel.api.adapter.web.conta.dto.CriarContaWebInput;
import br.com.ariel.api.adapter.web.conta.dto.CriarContaWebOutput;
import br.com.ariel.api.adapter.web.conta.mapper.ContaControllerMapper;
import br.com.ariel.api.port.domain.conta.BuscarContaPorIdUseCase;
import br.com.ariel.api.port.domain.conta.CriarContaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;



@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaControllerMapper mapper;
    private final CriarContaUseCase criarContaUseCase;
    private final BuscarContaPorIdUseCase buscarContaPorIdUseCase;

    @PostMapping
    public ResponseEntity<CriarContaWebOutput> criarConta(
            @RequestBody CriarContaWebInput input) {

        final var conta = criarContaUseCase.criarConta(mapper.toModel(input));

        return ResponseEntity.ok(mapper.toDto(conta));
    }

    @GetMapping("/{contaId}")
    public ResponseEntity<ContaWebOut> buscarContaPorId(
            @PathVariable("contaId") UUID contaId) {

        final var conta = buscarContaPorIdUseCase.buscarPorId(contaId);

        return ResponseEntity.ok(mapper.toDto(conta));
    }

}
