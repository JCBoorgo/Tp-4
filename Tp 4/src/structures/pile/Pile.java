package structures.pile;

import exception.PileException;

public class Pile {

	private NoeudPile sommet;
	private int taille;

	/**
	 * Construit une pile vide
	 */
	public Pile() {
		construirePile();
	}

	/**
	 * Vérifie si la pile est vide
	 */
	public boolean isEmpty() {
		return sommet == null;
	}

	/**
	 * Vide la pile
	 */
	public void vider() {
		construirePile();
	}

	private void construirePile() {
		this.sommet = null;
		this.taille = 0;
		System.gc();
	}

	/**
	 * Empile un objet dans la pile.
	 */
	public void empiler(Object pElement) {
		sommet = new NoeudPile(pElement, this.sommet);
		this.taille++;
	}

	/**
	 * Retourne l'objet dépilé.
	 */
	public Object depiler() throws PileException {
		Object retour = null;
		if (!isEmpty()) {
			retour = sommet;
			this.sommet = this.sommet.getPrecedent();
			this.taille--;
		}
		return ((NoeudPile) retour).getElement();
	}

	public Object getPremier() throws PileException {
		Object retour = null;

		if (!isEmpty())
			retour = sommet.getElement();
		else
			throw new PileException();

		return retour;
	}

	public String toString() {
		String s = "";
		NoeudPile courant = this.sommet;
		for (int i = 0; i < this.taille; i++) {
			s += courant.getElement()+"/n";
			courant = courant.getPrecedent();
		}

		return s;
	}

	/**
	 * retourne la taille courante de la pile
	 */
	public int size() {
		return this.taille;
	}
}
