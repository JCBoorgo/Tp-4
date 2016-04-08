package structures.pile;

/**
 * Classe interne NoeudPile seulement utile pour la pile
 */
public class NoeudPile {
	private Object element;
	private NoeudPile precedent;
	
	public NoeudPile(Object pElement) {
		this(pElement, null);
	}

	public NoeudPile(Object pElement, NoeudPile pPrecedent) {
		this.element = pElement;
		this.precedent = pPrecedent;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public void setPrecedent(NoeudPile precedent) {
		this.precedent = precedent;
	}
	
	NoeudPile getPrecedent() {
		return this.precedent;
	}

	Object getElement() {
		return this.element;
	}
}