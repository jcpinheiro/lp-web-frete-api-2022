package edu.ifma.lpweb.freteapi.api.controller;

import edu.ifma.lpweb.freteapi.api.dto.input.ItemRequest;
import edu.ifma.lpweb.freteapi.api.dto.output.ItemResponse;
import edu.ifma.lpweb.freteapi.api.mapper.ItemMapperAdapter;
import edu.ifma.lpweb.freteapi.domain.model.Item;
import edu.ifma.lpweb.freteapi.domain.service.BuscaEntregaService;
import edu.ifma.lpweb.freteapi.domain.service.RegistraItemNaEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{id}/itens")
public class RegistraItemController {

    private final RegistraItemNaEntregaService service;
    private final BuscaEntregaService buscaEntregaService;
    private final ItemMapperAdapter dtoAdapter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse registra(@PathVariable(name = "id") Integer entregaId,
                                  @Valid @RequestBody ItemRequest itemRequest ) {

        Item item = service.registra(entregaId, dtoAdapter.toEntity(itemRequest) );
        return dtoAdapter.toModelResponse(item );
    }

    @GetMapping
    public List<ItemResponse> lista(@PathVariable(name = "id") Integer entregaId ) {

        List<Item> itens = buscaEntregaService.buscarIntens(entregaId );
        return dtoAdapter.toCollectionModel(itens );
    }

}
