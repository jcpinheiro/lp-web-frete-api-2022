package edu.ifma.lpweb.freteapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrosDeValidacao {

	private LocalDateTime dataHora;
	private String titulo;
	private List<Erro> erros = new ArrayList<>();

	public ErrosDeValidacao(LocalDateTime dataHora, String titulo) {
		this.dataHora = dataHora;
		this.titulo = titulo;
	}

	public void adiciona(Erro erro ) {
		erros.add(erro );
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public List<Erro> getErros() {
		return erros;
	}
}