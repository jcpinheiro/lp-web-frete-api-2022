package edu.ifma.lpweb.freteapi.domain.service;

import edu.ifma.lpweb.freteapi.domain.exception.EntidadeNaoEncontradaException;
import edu.ifma.lpweb.freteapi.domain.model.Entrega;
import edu.ifma.lpweb.freteapi.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Integer id) {
		return  buscaPor(id)
				.orElseThrow(()
						-> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}

	public List<Entrega> todas() {
		return entregaRepository.findAll();
	}


	public Optional<Entrega> buscaPor(Integer id) {
		return entregaRepository.findById(id );
	}
}