package cartes;

import java.io.Serializable;

/**
 * Enum qui gère la valeur des cartes
 * 
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 *
 */
public enum ValeurCarte implements Serializable {
	V_AS("A", 1), V_2("2", 2), V_3("3", 3), V_4("4", 4), V_5("5", 5), V_6("6", 6), V_7("7", 7), V_8("8", 8), V_9("9",
			9), V_10("10", 10), V_JACK("J", 11), V_QUEEN("Q", 12), V_KING("K", 13);

	private String symbole = null;
	private int valeur = 0;

	/**
	 * Constructeur des valeurs
	 * 
	 * @param symbole
	 * @param valeur
	 */
	private ValeurCarte(String symbole, int valeur) {
		setSymbole(symbole);
		setValeur(valeur);
	}

	/**
	 * Retourne le symbole de la valeur
	 * 
	 * @return Symbole
	 */
	public String getSymbole() {
		return symbole;
	}

	/**
	 * Change le symbole de la valeur
	 * 
	 * @param symbole
	 *            - Nouveau symbole
	 */
	private void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	/**
	 * Retourne la valeur
	 * 
	 * @return La valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * Change la valeur
	 * 
	 * @param valeur
	 *            - Nouvelle valeur
	 */
	private void setValeur(int valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return getValeur() + " " + getSymbole();
	}
}
