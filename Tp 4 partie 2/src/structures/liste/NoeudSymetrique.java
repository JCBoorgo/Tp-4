package structures.liste;

import java.io.Serializable;

/**
 * Classe d'implémentation d'un noeud auto-référencé d'une liste symétrique
 *
 * @author Jocelyn
 */
public class NoeudSymetrique implements Serializable {

	private static final long serialVersionUID = 7574500060106595604L;

	/**
	 * Un pointeur sur l'élément du noeud ou la valeur à conserver
	 */
	private Object element;

	/**
	 * Un pointeur sur le noeud suivant
	 */
	private NoeudSymetrique suivant;

	/**
	 * Un pointeur sur le noeud precedent
	 */
	private NoeudSymetrique precedent;

	/**
	 * Constructeur de noeud
	 *
	 * @param pElement
	 *            l'élément à mettre dans le noeud
	 */
	public NoeudSymetrique(Object pElement) {
		this(pElement, null, null);
	}

	/**
	 * Constructeur de noeud
	 *
	 * @param pElement
	 *            l'élément à mettre dans le noeud
	 * @param pSuivant
	 *            un pointeur vers le noeud suivant
	 * @param pPrecedent
	 *            un pointeur vers le noeud précédent
	 */
	public NoeudSymetrique(Object pElement, NoeudSymetrique pSuivant, NoeudSymetrique pPrecedent) {
		this.setElement(pElement);
		this.setSuivant(pSuivant);
		this.setPrecedent(pPrecedent);
	}

	/**
	 * Obtenir l'élément qui est dans le noeud
	 *
	 * @return Object, l'élément qui est dans le noeud. "null" est possible.
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * Mettre à jour l'élément dans le noeud
	 *
	 * @param pElement
	 *            la nouvelle valeur de l'élément qui est dans le noeud. "null"
	 *            est possible
	 */
	public void setElement(Object pElement) {
		this.element = pElement;
	}

	/**
	 * Obtenir le pointeur vers le noeud suivant
	 *
	 * @return NoeudSymetrique, pointeur vers le noeud suivant ou null
	 */
	public NoeudSymetrique getSuivant() {
		return suivant;
	}

	/**
	 * Mettre à jour le pointeur suivant vers un autre noeud
	 *
	 * @param pSuivant
	 *            la nouvelle valeur du pointeur, "null" est possible
	 */
	public void setSuivant(NoeudSymetrique pSuivant) {
		this.suivant = pSuivant;
	}

	/**
	 * Obtenir le pointeur vers le noeud précédent
	 *
	 * @return NoeudSymetrique, pointeur vers le noeud précédent ou null
	 */
	public NoeudSymetrique getPrecedent() {
		return precedent;
	}

	/**
	 * Mettre à jour le pointeur précédent vers un autre noeud
	 *
	 * @param pPrecedent
	 *            la nouvelle valeur du pointeur, "null" est possible
	 */
	public void setPrecedent(NoeudSymetrique pPrecedent) {
		this.precedent = pPrecedent;
	}
}
