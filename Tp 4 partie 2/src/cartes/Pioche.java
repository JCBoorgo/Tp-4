package cartes;

import java.io.Serializable;

import structures.liste.ListeSymetrique;

/**
 * Classe pour gérer la pioche
 * 
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 *
 */
public class Pioche implements Serializable {
	private ListeSymetrique pioche = null;

	/**
	 * Constructeur de la pioche qui prend un paquet en paramètre (qui
	 * constituera la pioche)
	 * 
	 * @param paquet
	 *            - Le paquet qui va devenir la pioche
	 */
	public Pioche(PaquetDeCartes paquet) {
		pioche = new ListeSymetrique();
		while (!paquet.isEmpty()) {
			pioche.add(paquet.prendreCarte(paquet.size()));
		}
	}

	/**
	 * Prend et enlève la carte du dessus de la pioche
	 * 
	 * @return La carte pigée
	 */
	public Carte piger() {
		return (Carte) pioche.get(this.size() - 1);
	}

	/**
	 * Prend la carte du dessus de la pioche sans l'enlever
	 * 
	 * @return La carte du dessus
	 */
	public String consulterDessus() {
		return ((Carte) (pioche.get(this.size() - 1))).toStringCarte();
	}

	/**
	 * Détermine si le paquet est vide
	 * 
	 * @return Vrai si la pioche est vide, faux sinon
	 */
	public boolean isEmpty() {
		return pioche.isEmpty();
	}

	/**
	 * Retourne la taille de la pioche
	 * 
	 * @return Nombre de cartes restantes
	 */
	public int size() {
		return pioche.size();
	}

}
