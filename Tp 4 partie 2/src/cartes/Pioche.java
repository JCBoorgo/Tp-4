package cartes;

import java.io.Serializable;

import structures.liste.ListeSymetrique;

public class Pioche implements Serializable {
	private ListeSymetrique pioche = null;

	public Pioche(PaquetDeCartes paquet) {
		pioche = new ListeSymetrique();
		while (!paquet.isEmpty()) {
			pioche.add(paquet.prendreCarte(paquet.size()));
		}
	}

	public Carte piger() {
		return (Carte) pioche.get(this.size() - 1);
	}

	public String consulterDessus() {
		return ((Carte) (pioche.get(this.size() - 1))).toStringCarte();
	}

	public boolean isEmpty() {
		return pioche.isEmpty();
	}

	public int size() {
		return pioche.size();
	}

}
