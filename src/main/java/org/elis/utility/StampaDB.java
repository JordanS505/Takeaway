package org.elis.utility;

import jakarta.persistence.Persistence;

public class StampaDB {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("Takeaway");
	}
}
