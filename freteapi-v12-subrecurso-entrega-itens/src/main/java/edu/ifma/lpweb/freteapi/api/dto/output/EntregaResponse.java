package edu.ifma.lpweb.freteapi.api.dto.output;

import edu.ifma.lpweb.freteapi.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class EntregaResponse {

	private Long id;
	private ClienteIdNomeResponse cliente;
	private DestinatarioResponse destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private LocalDateTime dataPedido;

	// private LocalDateTime dataFinalizacao;
	
}