package cartes;

import java.awt.Color;
import java.io.Serializable;

/**
 * Enum qui gère la sorte des cartes
 * 
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 *
 */
public enum SorteCarte implements Serializable {
	COEUR('♥', Color.RED), CARREAU('♦', Color.RED), PIQUE('♠', Color.BLACK), TREFLE('♣', Color.BLACK);

	private char symbole = ' ';
	private Color couleur = null;

	/**
	 * Constructeur de la sorte des cartes
	 * 
	 * @param symbole
	 * @param couleur
	 */
	private SorteCarte(char symbole, Color couleur) {
		setSymbole(symbole);
		setCouleur(couleur);
	}

	/**
	 * Retourne le symbole représentant la sorte
	 * 
	 * @return Symbole de la carte
	 */
	public char getSymbole() {
		return symbole;
	}

	/**
	 * Change le symbole
	 * 
	 * @param symbole
	 *            - Nouveau symbole
	 */
	private void setSymbole(char symbole) {
		this.symbole = symbole;
	}

	/**
	 * Retourne la couleur de la sorte
	 * 
	 * @return La couleur de la sorte
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Change la couleur
	 * 
	 * @param couleur
	 *            - Nouvelle couleur
	 */
	private void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getSymbole() + "";
	}
}
