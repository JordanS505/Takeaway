package org.elis.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ordine {
	LocalDateTime data;
	
	Stato stato;

	public Ordine(LocalDateTime data, Stato stato) {
		this.data = data;
		this.stato = stato;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}
	
	
}
