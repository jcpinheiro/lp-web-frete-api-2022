package edu.ifma.lpweb.freteapi.api.mapper;

import edu.ifma.lpweb.freteapi.api.dto.input.EntregaRequest;
import edu.ifma.lpweb.freteapi.api.dto.output.EntregaResponse;
import edu.ifma.lpweb.freteapi.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {

	private ModelMapper modelMapper;
	
	public EntregaResponse toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaResponse.class);
	}
	
	public List<EntregaResponse> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaRequest entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
	
}