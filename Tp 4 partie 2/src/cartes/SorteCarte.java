package cartes;

import java.awt.Color;

public enum SorteCarte {
	COEUR('♥', Color.RED), CARREAU('♦', Color.RED), PIQUE('♠', Color.BLACK), TREFLE('♣', Color.BLACK);

	private char symbole = ' ';
	private Color couleur = null;

	private SorteCarte(char symbole, Color couleur) {
		setSymbole(symbole);
		setCouleur(couleur);
	}

	public char getSymbole() {
		return symbole;
	}

	private void setSymbole(char symbole) {
		this.symbole = symbole;
	}

	public Color getCouleur() {
		return couleur;
	}

	private void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getSymbole() + "";
	}
}
