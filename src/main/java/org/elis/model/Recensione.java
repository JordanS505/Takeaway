package org.elis.model;

public class Recensione {
	private Double voto;
	
	private String testo;

	private Long idOrdine;
	
	private Long idUtente;
	
	public Recensione(Double voto, String testo,Long idOrdine,Long idUtente) {
		this.voto = voto;
		this.testo = testo;
		this.idOrdine=idOrdine;
		this.idUtente=idUtente;
	}

	public Double getVoto() {
		return voto;
	}

	public void setVoto(Double voto) {
		this.voto = voto;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Long getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Long idOrdine) {
		this.idOrdine = idOrdine;
	}

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}
	
	
}
