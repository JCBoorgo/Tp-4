package cartes;

import java.io.Serializable;

import exception.ConstructeurException;

public class Carte implements Comparable<Carte>, Serializable {

	public static final Character IMAGE_DOS = ' ';
	private SorteCarte sorte = null;
	private ValeurCarte valeur = null;
	private boolean visible = false;

	public Carte(ValeurCarte valeur, SorteCarte sorte) throws ConstructeurException {
		if ((valeur != null) && (sorte != null)) {
			setSorte(sorte);
			setValeur(valeur);
			setVisible(false);
		} else {
			throw new ConstructeurException();
		}
	}

	public SorteCarte getSorte() {
		return sorte;
	}

	private void setSorte(SorteCarte sorte) {
		if (sorte != null) {
			this.sorte = sorte;
		}
	}

	public ValeurCarte getValeur() {
		return valeur;
	}

	private void setValeur(ValeurCarte valeur) {
		if (valeur != null) {
			this.valeur = valeur;
		}
	}

	public boolean estVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getValeurSymbole() {
		return valeur.getSymbole();
	}

	public char getSorteSymbole() {
		return sorte.getSymbole();
	}

	public String toStringCarte() {
		String s = "";
		if (this.estVisible()) {
			s = this.getValeurSymbole() + this.getSorteSymbole();
		} else {
			s += IMAGE_DOS;
		}
		return s;
	}

	@Override
	public int compareTo(Carte o) {
		int valeur = 0;
		valeur = o.getValeur().getValeur() - this.getValeur().getValeur();
		if (valeur == 0) {
			valeur = this.getSorte().compareTo(o.getSorte());
		}
		return valeur;
	}

	@Override
	public boolean equals(Object obj) {
		boolean egal = false;
		if (obj instanceof Carte) {
			Carte temp = (Carte) obj;
			egal = ((this.getValeur().equals(temp.getValeur())) && (this.getSorte().equals(temp.getSorte())));
		}
		return egal;
	}

	@Override
	public String toString() {
		return this.estVisible() + " " + this.getValeur() + " " + this.getSorte();
	}

}
