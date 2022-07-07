package edu.ifma.lpweb.freteapi.domain.service;

import edu.ifma.lpweb.freteapi.domain.exception.NegocioException;
import edu.ifma.lpweb.freteapi.domain.model.Cliente;
import edu.ifma.lpweb.freteapi.domain.model.Entrega;
import edu.ifma.lpweb.freteapi.domain.model.StatusEntrega;
import edu.ifma.lpweb.freteapi.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SolicitacaoEntregaService {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {

		Cliente cliente = clienteService
				          .buscaPor(entrega.getCliente().getId())
				          .orElseThrow(() -> new NegocioException("Cliente não cadastrado"));
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);

		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}

}