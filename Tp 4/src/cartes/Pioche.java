package cartes;

import structures.pile.Pile;

public class Pioche {
	//TODO PaquetDeCartes
	
	private Pile pioche = null;
	Pioche(PaquetDeCartes paquet){
		//TODO
	}
	
	public Carte piger(){
		return (Carte) pioche.depiler();
	}
	
	public String consulterDessus(){
		return ((Carte) (pioche.getPremier())).toStringCarte();
	}
	
	public boolean isEmpty(){
		return pioche.isEmpty();
	}
	
	public int size(){
		return pioche.size();
	}
	
}
