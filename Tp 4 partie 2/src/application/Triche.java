package application;

import javax.swing.JOptionPane;
import cartes.Carte;
import cartes.ValeurCarte;
import structures.liste.ListeSymetrique;

/**
 * Classe utilitaire qui permet à un joueur de tricher lorsque la partie est
 * terminée.
 *
 * @author Jocelyn
 *
 */
public class Triche {

	/**
	 * Informe l'utilisateur qu'il n'a plus de possibilités. On permet alors à
	 * l'utilisateur de tricher un peu pour se déprendre.
	 *
	 * @param parent
	 *            la classe de jeu à modifier.
	 */
	public static void finiOuTriche(AcesUpSolitaire parent) {
		int choixColonne = 0;

		Object[] options = { "Mon dieu NON !!!!!!", "monter 1", "monter 2", "monter 3", "monter 4", "descendre 1",
				"descendre 2", "descendre 3", "descendre 4" };
		choixColonne = JOptionPane.showOptionDialog(parent,
				"Désolé, la partie est terminée, il n'est plus possible "
						+ "de jouer un autre coup \n... Voulez-vous tricher ?\n"
						+ " (le jeu va descendre ou monter la carte la plus forte dans " + "la colonne de votre choix)",
				"Fin de partie !", JOptionPane.WARNING_MESSAGE, 0, null, options, options[0]);

		if (choixColonne > 0) {
			parent.addTricher();
			if (choixColonne < 5) {
				tricheMonter(parent.getColonneCartes(choixColonne - 1));
				parent.dessinerListeCartes(choixColonne - 1);
			} else {
				tricheDescendre(parent.getColonneCartes(choixColonne - 5));
				parent.dessinerListeCartes(choixColonne - 5);
			}
		} else {
			JOptionPane.showMessageDialog(parent, "On commence une nouvelle partie");
			parent.initPartie();
		}
	}

	/**
	 * Cette méthode prend la carte la plus forte de la colonne et elle la la
	 * monte en haut de la colonne. En cas d'égalité, La méthode conserve la
	 * carte la plus haute dans la colonne. Ça permet en autre de changer l'as
	 * de place.
	 *
	 * @param colonneCartes
	 *            la colonne à modifier.
	 *
	 */
	// TODO tester
	private static void tricheMonter(ListeSymetrique colonneCartes) {
		// Trouver la carte la plus forte
		// La mettre au top de la colonne
		// Updater les colonnes
		int indexCarteForte = 0;
		Carte carteForte = (Carte) colonneCartes.get(0);
		if (colonneCartes.size() > 1) {
			for (int i = 0; i < colonneCartes.size(); i++) {
				if (carteForte.compareTo((Carte) colonneCartes.get(i)) > 0) {
					indexCarteForte = i;
					carteForte = (Carte) colonneCartes.get(i);
				}
			}
		}
		colonneCartes.add(0, carteForte);
		colonneCartes.remove(indexCarteForte + 1);
	}

	/**
	 * Cette méthode prend la carte la plus forte de la colonne et elle la la
	 * descend en bas de la colonne. En cas d'égalité, La méthode conserve la
	 * carte la plus haute dans la colonne. Ça permet en autre de changer l'as
	 * de place.
	 *
	 * @param colonneCartes
	 *            la colonne à modifier.
	 *
	 */
	// TODO tester
	private static void tricheDescendre(ListeSymetrique colonneCartes) {
		// Trouver la carte la plus forte
		// La mettre au bas de la colonne
		// Updater les colonnes
		int indexCarteForte = 0;
		Carte carteForte = (Carte) colonneCartes.get(0);
		if (colonneCartes.size() > 1) {
			for (int i = 0; i < colonneCartes.size(); i++) {
				if (carteForte.compareTo((Carte) colonneCartes.get(i)) > 0) {
					indexCarteForte = i;
					carteForte = (Carte) colonneCartes.get(i);
				}
			}
		}
		colonneCartes.add(colonneCartes.size() - 1, carteForte);
		colonneCartes.remove(indexCarteForte);
	}

}
