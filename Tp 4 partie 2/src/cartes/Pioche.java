package cartes;

import structures.pile.Pile;

public class Pioche {
	private Pile pioche = null;

	public Pioche(PaquetDeCartes paquet) {
		pioche = new Pile();
		while (!paquet.isEmpty()) {
			pioche.empiler(paquet.prendreCarte(paquet.size()));
		}
	}

	public Carte piger() {
		return (Carte) pioche.depiler();
	}

	public String consulterDessus() {
		return ((Carte) (pioche.getPremier())).toStringCarte();
	}

	public boolean isEmpty() {
		return pioche.isEmpty();
	}

	public int size() {
		return pioche.size();
	}

}
