package com.kai.wang.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RequisicaoOferta {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Long pedidoId;
	
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	@NotNull
	private String valor;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String dataEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setId(this.getPedidoId());
		oferta.setComentario(this.getComentario());
		LocalDate novaDataOferta = LocalDate.parse(this.getDataEntrega(), formatter);
		oferta.setDataEntrega(novaDataOferta);
		oferta.setValor(new BigDecimal(this.getValor()));
		
		return oferta;
	}
	
	@Override
	public String toString() {
		return String.format("[ id: %d, comentario: %s, data oferta: %s, valor: %s ]", this.getPedidoId(), this.getComentario(), this.getDataEntrega(), this.getValor());
	}
	

}
