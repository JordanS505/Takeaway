package org.elis.model;

import java.time.LocalDateTime;
import java.util.List;

import org.elis.enumerazioni.Stato;

import jakarta.persistence.*;

@Entity
public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private LocalDateTime data;
	@Column(nullable=false)
	private Stato stato;
	
	@ManyToOne
	private Utente ristoratore;
	@ManyToOne
	private Utente cliente;
	@ManyToMany
	private List<ElementoOrdine> elementi; 
	@OneToOne
	private Recensione recensione;

	
	
	public Ordine() {
	}

	public Ordine(LocalDateTime data, Stato stato) {
		this.data = data;
		this.stato = stato;
	}	

	public Ordine(LocalDateTime data, Stato stato, Utente ristoratore, Utente cliente, List<ElementoOrdine> elementi) {
		this.data = data;
		this.stato = stato;
		this.ristoratore = ristoratore;
		this.cliente = cliente;
		this.elementi = elementi;
	}

	public Ordine(Long id, LocalDateTime data, Stato stato, Utente ristoratore, Utente cliente, List<ElementoOrdine> elementi, Recensione recensione) {
		this.id=id;
		this.data = data;
		this.stato = stato;
		this.ristoratore = ristoratore;
		this.cliente = cliente;
		this.elementi = elementi;
		this.recensione=recensione;
	}

	public Utente getRistoratore() {
		return ristoratore;
	}

	public void setRistoratore(Utente ristoratore) {
		this.ristoratore = ristoratore;
	}

	public Utente getCliente() {
		return cliente;
	}

	public void setCliente(Utente cliente) {
		this.cliente = cliente;
	}

	public List<ElementoOrdine> getElementi() {
		return elementi;
	}

	public void setElementi(List<ElementoOrdine> elementi) {
		this.elementi = elementi;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recensione getRecensione() {
		return recensione;
	}

	public void setRecensione(Recensione recensione) {
		this.recensione = recensione;
	}
	
	
}
