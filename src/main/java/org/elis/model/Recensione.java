package org.elis.model;

public class Recensione {
	private Double voto;
	
	private String Testo;

	public Recensione(Double voto, String testo) {
		this.voto = voto;
		Testo = testo;
	}

	public Double getVoto() {
		return voto;
	}

	public void setVoto(Double voto) {
		this.voto = voto;
	}

	public String getTesto() {
		return Testo;
	}

	public void setTesto(String testo) {
		Testo = testo;
	}
	
	
}
