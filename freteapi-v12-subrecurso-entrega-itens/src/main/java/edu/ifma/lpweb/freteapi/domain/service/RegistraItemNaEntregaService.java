package edu.ifma.lpweb.freteapi.domain.service;

import edu.ifma.lpweb.freteapi.domain.model.Entrega;
import edu.ifma.lpweb.freteapi.domain.model.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class RegistraItemNaEntregaService {

    private BuscaEntregaService buscaEntregaService;


    @Transactional
    public Item registra(Integer entregaId, Item item ) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return entrega.adiciona(item );
    }

}
