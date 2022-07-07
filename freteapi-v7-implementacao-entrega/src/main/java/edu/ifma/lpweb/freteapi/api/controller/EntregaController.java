package edu.ifma.lpweb.freteapi.api.controller;

import edu.ifma.lpweb.freteapi.domain.model.Entrega;
import edu.ifma.lpweb.freteapi.domain.service.BuscaEntregaService;
import edu.ifma.lpweb.freteapi.domain.service.ClienteService;
import edu.ifma.lpweb.freteapi.domain.service.FinalizacaoEntregaService;
import edu.ifma.lpweb.freteapi.domain.service.SolicitacaoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private final SolicitacaoEntregaService solicitacaoEntregaService;
	private final ClienteService clienteService;
	private final BuscaEntregaService buscaEntregaService;
	private final FinalizacaoEntregaService finalizacaoEntregaService;

	@Autowired
	public EntregaController(SolicitacaoEntregaService solicitacaoEntregaService,
							 ClienteService clienteService,
							 BuscaEntregaService buscaEntregaService,
							 FinalizacaoEntregaService finalizacaoEntregaService) {
		this.solicitacaoEntregaService = solicitacaoEntregaService;
		this.clienteService = clienteService;
		this.buscaEntregaService = buscaEntregaService;
		this.finalizacaoEntregaService = finalizacaoEntregaService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega ) {
		return solicitacaoEntregaService.solicitar(entrega );
	}

	@GetMapping
	public List<Entrega> listar() {
		return buscaEntregaService.todas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Entrega> busca(@PathVariable Integer id ) {
		return buscaEntregaService.buscaPor(id )
				.map( ResponseEntity::ok )
				.orElse( ResponseEntity.notFound().build() );
	}
	
	@PutMapping("/{id}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Entrega finalizar(@PathVariable Integer id) {
		return finalizacaoEntregaService.finalizar(id );
	}
	
}