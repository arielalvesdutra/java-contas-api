package br.com.ariel.api.adapter.data.conta.jpa;


import br.com.ariel.api.adapter.data.conta.mapper.ContaDataMapper;
import br.com.ariel.api.adapter.data.conta.repository.ContaRepository;
import br.com.ariel.api.domain.model.conta.Conta;
import br.com.ariel.api.port.integration.data.PersistirContaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistirContaPortImpl implements PersistirContaPort {

    private final ContaDataMapper mapper;
    private final ContaRepository contaRepository;

    @Override
    public Conta persistir(Conta conta) {
        final var entity = contaRepository.save(mapper.toEntity(conta));
        return mapper.toModel(entity);
    }

}
