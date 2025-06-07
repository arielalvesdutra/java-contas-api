package br.com.ariel.api.adapter.data.conta.jpa;

import br.com.ariel.api.adapter.data.conta.mapper.ContaDataMapper;
import br.com.ariel.api.adapter.data.conta.repository.ContaRepository;
import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.integration.data.BuscarContaPorIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BuscarContaPorIdPortImpl implements BuscarContaPorIdPort {

    private final ContaDataMapper mapper;
    private final ContaRepository contaRepository;

    @Override
    public Optional<Conta> buscarPorId(UUID id) {
        return contaRepository.findById(id).map(mapper::toModel);
    }

}
