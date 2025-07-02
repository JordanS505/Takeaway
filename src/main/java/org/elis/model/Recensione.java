package org.elis.model;

public class Recensione {
	private int voto;
	
	private String Testo;

	public Recensione(int voto, String testo) {
		this.voto = voto;
		Testo = testo;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getTesto() {
		return Testo;
	}

	public void setTesto(String testo) {
		Testo = testo;
	}
	
	
}
