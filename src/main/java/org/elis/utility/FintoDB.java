package org.elis.utility;

import java.util.ArrayList;
import java.util.List;

import org.elis.model.*;

import jakarta.persistence.Persistence;

public class FintoDB {
	private List<Utente> utenti = new ArrayList<>();

	private List<Ordine> ordini = new ArrayList<>();

	private List<ElementoOrdine> elementiOrdini = new ArrayList<>();

	private List<Portata> portate= new ArrayList<>();

	private List<Categoria> categorie= new ArrayList<>();

	private List<Recensione> recensioni= new ArrayList<>();
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("Takeaway");
				
	}
}
