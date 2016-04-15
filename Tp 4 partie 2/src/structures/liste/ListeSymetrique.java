package structures.liste;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

/**
 * Classe qui représente une liste dynamique symétrique (doublement liée). Elle
 * implémente certains comportements de l'interface "List". Elle accepte les
 * valeurs "null", donc les doublons
 *
 * @author Jean-Christophe Bourgault et David-Alexandre Deshaies-Lévesque
 *
 */
public class ListeSymetrique implements List<Object>, Serializable {

	private static final long serialVersionUID = 2808179796983375246L;

	/**
	 * Pointeur de la tête de liste
	 */
	private NoeudSymetrique tete = null;

	/**
	 * Pointeur de fin de la liste, pointe sur le dernier noeud.
	 */
	private NoeudSymetrique fin = null;

	/**
	 * Conserve la taille de la liste
	 */
	private int taille = 0;

	/**
	 * Constructeur sans paramètre
	 */
	public ListeSymetrique() {
		this.tete = this.fin = null;
		this.taille = 0;
	}

	/**
	 * Retourne un pointeur sur le noeud dont l'index est reçu en entrée
	 *
	 * @param index
	 *            , un index à rechercher.
	 *
	 * @return NoeudSymetrique, un pointeur sur le noeud trouvé, sinon null
	 */
	public NoeudSymetrique findNode(int index) {
		NoeudSymetrique courant = this.tete;
		int indexCourant = 0;

		if ((index >= 0) && (index < this.size())) {
			// Parcourt de la liste pour trouver le noeud selon l'index reçu
			while ((courant != null) && (indexCourant < index)) {
				courant = courant.getSuivant();
				indexCourant++;
			}
		}

		return (indexCourant == index) ? courant : null;
	}

	/**
	 * Retourne un pointeur sur le noeud qui contient l'élément reçu en entrée
	 *
	 * @param o
	 *            , un objet à comparer ou null
	 *
	 * @return NoeudSymetrique, un pointeur sur le noeud trouvé, sinon null
	 */
	public NoeudSymetrique findNode(Object o) {
		NoeudSymetrique courant = this.tete;

		// Parcourt de la liste pour trouver le noeud selon l'objet reçu
		// Le pointeur d'objet n'est pas null
		if (o != null) {
			while ((courant != null) && ((courant.getElement() == null)
					|| ((courant.getElement() != null) && (!courant.getElement().equals(o))))) {
				courant = courant.getSuivant();
			}
		} else {
			while ((courant != null) && (courant.getElement() != null)) {
				courant = courant.getSuivant();
			}
		}

		return courant;
	}

	/**
	 * Ajoute e à l'index passé en paramètre
	 * 
	 * @param index
	 *            - l'index où mettre l'objet
	 * @param e
	 *            - objet à ajouter
	 */
	@Override
	//TODO test
	public void add(int index, Object e) throws IndexOutOfBoundsException {
		if ((index <= this.size()) && (index >= 0)) {
			if (index == this.size() - 1) {
				this.add(e);
			} else if (index == 0) {
				NoeudSymetrique temp = new NoeudSymetrique(e);
				this.tete.setPrecedent(temp);
				temp.setSuivant(tete);
				this.tete = temp;
			} else {
				NoeudSymetrique temp = new NoeudSymetrique(e);
				this.findNode(index).setPrecedent(temp);
				temp.setSuivant(this.findNode(index));
				this.findNode(index - 1).setSuivant(temp);
				temp.setPrecedent(this.findNode(index - 1));
			}
			taille++;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Place l'objet e à la fin de la liste
	 * 
	 * @param e
	 *            - objet à ajouter
	 */
	@Override
	//TODO test
	public boolean add(Object e) {
		if (this.isEmpty()) {
			tete = new NoeudSymetrique(e);
			fin = tete;
		} else {
			NoeudSymetrique temp = new NoeudSymetrique(e, null, fin);
			this.fin.setSuivant(temp);
			fin = temp;
		}
		this.taille++;
		return true;
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		return false;
	}

	/**
	 * Vide la liste
	 */
	@Override
	//TODO test
	public void clear() {
		this.tete = null;
		this.fin = null;
		System.gc();
	}

	@Override
	public boolean contains(Object o) {
		return (findNode(o) != null);
	}

	@Override
	public boolean containsAll(Collection c) {
		return false;
	}

	/**
	 * Retourne l'objet à l'index passé en paramètre
	 * 
	 * @param index
	 *            - index de l'objet voulu
	 */
	@Override
	//TODO test
	public Object get(int index) {
		return findNode(index).getElement();
	}

	/**
	 * Cherche l'objet o et retourne son index
	 * 
	 * @param o
	 *            - objet à trouver
	 */
	@Override
	//TODO test
	public int indexOf(Object o) {
		NoeudSymetrique noeudCourant = tete;
		boolean trouve = false;
		int index = 0;
		if (!this.isEmpty()) {
			while (!trouve) {
				trouve = noeudCourant.getElement().equals(o);
				if (!trouve) {
					index++;
					noeudCourant = noeudCourant.getSuivant();
				}
				if (index == this.size()) {
					trouve = true;
					index = -1;
				}
			}
		}
		return index;
	}

	@Override
	public boolean isEmpty() {
		return (this.taille <= 0);
	}

	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		return null;
	}

	/**
	 * Enlève le noeud à l'index passé en paramètre
	 * 
	 * @param index
	 *            - index du noeud à enlever
	 */
	@Override
	//TODO test
	public Object remove(int index) throws IndexOutOfBoundsException {
		Object temp = null;
		if (!this.isEmpty()) {
			temp = this.get(index);
			this.findNode(index + 1).setPrecedent(this.findNode(index - 1));
			this.findNode(index - 1).setSuivant(this.findNode(index + 1));
			System.gc();
		}
		return temp;
	}

	/**
	 * Enlève l'objet passé en paramètre
	 * 
	 * @param o
	 *            - objet à enlever
	 */
	@Override
	//TODO test
	public boolean remove(Object o) {
		if (this.contains(o)) {
			this.remove(this.findNode(o));
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public void replaceAll(UnaryOperator operator) {
		List.super.replaceAll(operator);
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	/**
	 * Remplace l'objet à l'index passé en paramètre par element et retourne
	 * l'ancien objet
	 * 
	 * @param index
	 *            - index de l'objet à remplacer
	 * @param element
	 *            - objet à mettre
	 */
	@Override
	//TODO test
	public Object set(int index, Object element) {
		Object temp = null;
		if (!this.isEmpty()) {
			temp = this.findNode(index);
			this.findNode(index).setElement(element);
		}
		return temp;
	}

	@Override
	public int size() {
		return this.taille;
	}

	@Override
	public void sort(Comparator is) {
		List.super.sort(is);
	}

	@Override
	public Spliterator spliterator() {
		return List.super.spliterator();
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		return null;
	}

	/**
	 * Retourne une chaîne représentant la liste
	 */
	@Override
	//TODO test
	public String toString() {
		String s = "";
		int indexCourant = 0;
		NoeudSymetrique courant = this.tete;
		while (indexCourant < this.size()) {
			s += courant.getElement().toString();
			courant = courant.getSuivant();
			indexCourant++;
		}
		return s;
	}
}
