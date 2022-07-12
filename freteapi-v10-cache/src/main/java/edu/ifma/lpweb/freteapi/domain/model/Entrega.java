package edu.ifma.lpweb.freteapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.ifma.lpweb.freteapi.domain.exception.NegocioException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Destinatario destinatario;

	@NotNull @Positive
	private BigDecimal taxa;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime dataPedido;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime dataFinalizacao;

	public void finalizar() {
		if (naoPodeSerFinalizada()) {
			throw new NegocioException("Entrega não pode ser finalizada");
		}
		this.setStatus(StatusEntrega.FINALIZADA);
		setDataFinalizacao(LocalDateTime.now());
	}
	public boolean podeSerFinalizada() {
		return StatusEntrega.PENDENTE.equals(getStatus());
	}
	
	public boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}
}
