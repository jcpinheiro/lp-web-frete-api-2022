package edu.ifma.lpweb.freteapi.api.controller;

import edu.ifma.lpweb.freteapi.api.dto.input.EntregaRequest;
import edu.ifma.lpweb.freteapi.api.dto.output.EntregaResponse;
import edu.ifma.lpweb.freteapi.api.mapper.EntregaMapper;
import edu.ifma.lpweb.freteapi.domain.model.Entrega;
import edu.ifma.lpweb.freteapi.domain.service.BuscaEntregaService;
import edu.ifma.lpweb.freteapi.domain.service.FinalizacaoEntregaService;
import edu.ifma.lpweb.freteapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private final SolicitacaoEntregaService solicitacaoEntregaService;
	private final BuscaEntregaService buscaEntregaService;
	private final FinalizacaoEntregaService finalizacaoEntregaService;
	private final EntregaMapper entregaAssembler;

/*
	@GetMapping
	public List<Entrega> listar() {
		return buscaEntregaService.todas();
	}
*/

	@GetMapping
	public List<EntregaResponse> listar() {
		return entregaAssembler.toCollectionModel(buscaEntregaService.todas());
	}

/*	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega ) {
		return solicitacaoEntregaService.solicitar(entrega );
	}*/

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaResponse solicitar(@Valid @RequestBody EntregaRequest entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);

		return entregaAssembler.toModel(entregaSolicitada );
	}

/*	@GetMapping("/{id}")
	public ResponseEntity<Entrega> busca(@PathVariable Integer id ) {
		return buscaEntregaService.buscaPor(id )
				.map(ResponseEntity::ok)
				.orElse( ResponseEntity.notFound().build() );
	}*/

	@GetMapping("/{id}")
	public ResponseEntity<EntregaResponse> buscar(@PathVariable Integer id ) {
		return buscaEntregaService.buscaPor(id )
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)) )
				.orElse(ResponseEntity.notFound().build() );
	}
	
	@PutMapping("/{id}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Entrega finalizar(@PathVariable Integer id ) {
		return finalizacaoEntregaService.finalizar(id);
	}

}