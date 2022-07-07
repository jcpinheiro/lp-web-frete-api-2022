package edu.ifma.lpweb.freteapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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