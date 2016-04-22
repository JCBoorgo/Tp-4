package cartes;

import java.io.Serializable;

import exception.ConstructeurException;

/**
 * Gère les cartes
 * 
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 */
public class Carte implements Comparable<Carte>, Serializable {

	public static final Character IMAGE_DOS = ' ';
	private SorteCarte sorte = null;
	private ValeurCarte valeur = null;
	private boolean visible = false;

	/**
	 * Constructeur prenant comme paramètres une valeur et une sorte de carte
	 * 
	 * @param valeur
	 *            - Valeur de la carte
	 * @param sorte
	 *            - Sorte de la carte
	 * @throws ConstructeurException
	 */
	public Carte(ValeurCarte valeur, SorteCarte sorte) throws ConstructeurException {
		if ((valeur != null) && (sorte != null)) {
			setSorte(sorte);
			setValeur(valeur);
			setVisible(false);
		} else {
			throw new ConstructeurException();
		}
	}

	/**
	 * Retourne la sorte de la carte
	 * 
	 * @return Sorte de la carte
	 */
	public SorteCarte getSorte() {
		return sorte;
	}

	/**
	 * Change la sorte de la carte
	 * 
	 * @param sorte
	 *            - Nouvelle sorte de la carte
	 */
	private void setSorte(SorteCarte sorte) {
		if (sorte != null) {
			this.sorte = sorte;
		}
	}

	/**
	 * Retourne la valeur de la carte
	 * 
	 * @return Valeur de la carte
	 */
	public ValeurCarte getValeur() {
		return valeur;
	}

	/**
	 * Change la valeur de la carte
	 * 
	 * @param valeur
	 *            - Nouvelle valeur de la carte
	 */
	private void setValeur(ValeurCarte valeur) {
		if (valeur != null) {
			this.valeur = valeur;
		}
	}

	/**
	 * Détermine la visibilité de la carte
	 * 
	 * @return Vrai si la carte est visible, faux sinon
	 */
	public boolean estVisible() {
		return visible;
	}

	/**
	 * Change la visibilité de la carte
	 * 
	 * @param visible
	 *            - Nouvelle visibilité
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * Retourne le symbole de la valeur de la carte
	 * 
	 * @return Symbole de la valeur de la carte
	 */
	public String getValeurSymbole() {
		return valeur.getSymbole();
	}

	/**
	 * Retourne le symbole de la sorte de la carte
	 * 
	 * @return Symbole de la sorte de la carte
	 */
	public char getSorteSymbole() {
		return sorte.getSymbole();
	}

	/**
	 * Donne une représentation de la carte si elle est visible, et le dos de la
	 * carte sinon
	 * 
	 * @return Représentation de la carte
	 */
	public String toStringCarte() {
		String s = "";
		if (this.estVisible()) {
			s = this.getValeurSymbole() + this.getSorteSymbole();
		} else {
			s += IMAGE_DOS;
		}
		return s;
	}

	/**
	 * Compare les cartes par valeur, puis par sorte si nécessaire
	 */
	@Override
	public int compareTo(Carte o) {
		int valeur = 0;
		valeur = o.getValeur().getValeur() - this.getValeur().getValeur();
		if (valeur == 0) {
			valeur = this.getSorte().compareTo(o.getSorte());
		}
		return valeur;
	}

	/**
	 * Détermine si les cartes sont égales
	 */
	@Override
	public boolean equals(Object obj) {
		boolean egal = false;
		if (obj instanceof Carte) {
			Carte temp = (Carte) obj;
			egal = ((this.getValeur().equals(temp.getValeur())) && (this.getSorte().equals(temp.getSorte())));
		}
		return egal;
	}

	/**
	 * Donne une représentation de la carte
	 */
	@Override
	public String toString() {
		return this.estVisible() + " " + this.getValeur() + " " + this.getSorte();
	}

}
