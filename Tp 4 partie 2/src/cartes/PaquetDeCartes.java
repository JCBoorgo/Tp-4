package cartes;

import java.io.Serializable;

import structures.liste.ListeSymetrique;

/**
 * Gère les paquets de cartes, composés de ListeSymetrique
 * 
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 *
 */
public class PaquetDeCartes implements Serializable {

	public static final int NBR_ECHANGE = 1000;
	private ListeSymetrique paquet = null;

	/**
	 * Constructeur des paquets de cartes sans paramètre, donc génère toutes les
	 * cartes possibles dans l'ordre
	 */
	public PaquetDeCartes() {
		paquet = new ListeSymetrique();
		for (ValeurCarte val : ValeurCarte.values()) {
			for (SorteCarte sorte : SorteCarte.values()) {
				paquet.add(new Carte(val, sorte));
			}
		}
	}

	/**
	 * Constructeur avec paramètres, pour avoir un paquet prédéfini
	 * 
	 * @param paquet
	 *            Paquet qu'on veut avoir
	 */
	public PaquetDeCartes(ListeSymetrique paquet) {
		if (paquet != null) {
			this.paquet = paquet;
		}
	}

	/**
	 * Mélange le paquet de cartes
	 */
	public void brasser() {
		int nbrFois = NBR_ECHANGE;
		for (int i = 0; i < nbrFois; i++) {
			int indUn = (int) Math.round(Math.random() * (paquet.size() - 1));
			int indDeux = (int) Math.round(Math.random() * (paquet.size() - 1));
			this.permuterCarte(indUn, indDeux);
		}
	}

	/**
	 * Échange deux cartes de place
	 * 
	 * @param index1
	 *            - Index de la première carte
	 * @param index2
	 *            - Index de la deuxième carte
	 */
	private void permuterCarte(int index1, int index2) {
		Carte temp = (Carte) this.paquet.get(index2);
		this.paquet.set(index2, this.paquet.get(index1));
		this.paquet.set(index1, temp);
	}

	/**
	 * Prend une carte à la position spécifiée et l'enlève du paquet sans
	 * changer sa visibilité
	 * 
	 * @param position
	 *            - Position de la carte à prendre
	 * @return La carte
	 */
	public Carte prendreCarte(int position) {
		Carte temp = null;
		Carte temp2 = null;
		if (validerPosition(position) && !paquet.isEmpty()) {
			temp = (Carte) paquet.get(paquet.size() - position);
			temp2 = new Carte(temp.getValeur(), temp.getSorte());
			paquet.remove(paquet.size() - position);
		}
		return temp2;
	}

	/**
	 * Renvoie la carte, sans l'enlever du paquet
	 * 
	 * @param position
	 *            - Position de la carte à voir
	 * @return La carte
	 */
	public Carte consulterCarte(int position) {
		Carte temp = null;
		if (validerPosition(position) && !paquet.isEmpty()) {
			temp = (Carte) paquet.get(paquet.size() - position);
		}
		return temp;
	}

	/**
	 * Change la visibilité de toutes les cartes
	 * 
	 * @param visible
	 *            - Nouvelle visibilité du paquet
	 */
	public void retournerToutesLesCartes(boolean visible) {
		for (Object carte : paquet) {
			((Carte) carte).setVisible(visible);
		}
	}

	/**
	 * Retourne la taille du paquet
	 * 
	 * @return Nombre de cartes restantes
	 */
	public int size() {
		return paquet.size();
	}

	/**
	 * Détermine si le paquet est vide
	 * 
	 * @return Vrai si le paquet est vide, faux sinon
	 */
	public boolean isEmpty() {
		return paquet.isEmpty();
	}

	/**
	 * Vérifie que la position passée en paramètre est dans les limites du
	 * paquet
	 * 
	 * @param position
	 *            - Position à valider
	 * @return Vrai si la position est valide, faux sinon
	 */
	private boolean validerPosition(int position) {
		return ((position > 0) && (position <= paquet.size()));
	}

}
