package cartes;

import java.io.Serializable;

import structures.liste.ListeSymetrique;

public class PaquetDeCartes implements Serializable {

	public static final int NBR_ECHANGE = 1000;
	private ListeSymetrique paquet = null;

	public PaquetDeCartes() {
		paquet = new ListeSymetrique();
		for (ValeurCarte val : ValeurCarte.values()) {
			for (SorteCarte sorte : SorteCarte.values()) {
				paquet.add(new Carte(val, sorte));
			}
		}
	}

	public PaquetDeCartes(ListeSymetrique paquet) {
		if (paquet != null) {
			this.paquet = paquet;
		}
	}

	public void brasser() {
		int nbrFois = NBR_ECHANGE;
		for (int i = 0; i < nbrFois; i++) {
			int indUn = (int) Math.round(Math.random() * (paquet.size() - 1));
			int indDeux = (int) Math.round(Math.random() * (paquet.size() - 1));
			this.permuterCarte(indUn, indDeux);
		}
	}

	private void permuterCarte(int index1, int index2) {
		Carte temp = (Carte) this.paquet.get(index2);
		this.paquet.set(index2, this.paquet.get(index1));
		this.paquet.set(index1, temp);
	}

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

	public Carte consulterCarte(int position) {
		Carte temp = null;
		if (validerPosition(position) && !paquet.isEmpty()) {
			temp = (Carte) paquet.get(paquet.size() - position);
		}
		return temp;
	}

	public void retournerToutesLesCartes(boolean visible) {
		for (Object carte : paquet) {
			((Carte) carte).setVisible(visible);
		}
	}

	public int size() {
		return paquet.size();
	}

	public boolean isEmpty() {
		return paquet.isEmpty();
	}

	private boolean validerPosition(int position) {
		return ((position > 0) && (position < paquet.size()));
	}

}
