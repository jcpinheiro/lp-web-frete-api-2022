package edu.ifma.lpweb.freteapi.api.mapper;

import edu.ifma.lpweb.freteapi.api.dto.input.EntregaRequest;
import edu.ifma.lpweb.freteapi.api.dto.input.ItemRequest;
import edu.ifma.lpweb.freteapi.api.dto.output.EntregaResponse;
import edu.ifma.lpweb.freteapi.api.dto.output.ItemResponse;
import edu.ifma.lpweb.freteapi.domain.model.Entrega;
import edu.ifma.lpweb.freteapi.domain.model.Item;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ItemMapperAdapter {

	private ModelMapper modelMapper;
	
	public ItemResponse toModelResponse(Item item) {
		return modelMapper.map(item, ItemResponse.class);
	}
	
	public List<ItemResponse> toCollectionModel(List<Item> itens) {
		return itens.stream()
				.map(this::toModelResponse)
				.collect(Collectors.toList());
	}
	
	public Item toEntity(ItemRequest itemRequest) {
		return modelMapper.map(itemRequest, Item.class);
	}
	
}