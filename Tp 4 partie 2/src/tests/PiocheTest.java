package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cartes.Carte;
import cartes.PaquetDeCartes;
import cartes.Pioche;
import cartes.SorteCarte;
import cartes.ValeurCarte;
import structures.liste.ListeSymetrique;

public class PiocheTest {
	ListeSymetrique l1;
	PaquetDeCartes pdc1;
	Pioche p1;
	//TODO

	@Before
	public void setUp() throws Exception {
		l1 = new ListeSymetrique();
		l1.add(new Carte(ValeurCarte.V_2, SorteCarte.PIQUE));
		l1.add(new Carte(ValeurCarte.V_5, SorteCarte.COEUR));
		l1.add(new Carte(ValeurCarte.V_3, SorteCarte.CARREAU));
		pdc1 = new PaquetDeCartes(l1);
		p1 = new Pioche(pdc1);
	}

	@Test
	public void testPiger() {
		Carte c1 = p1.piger();
		assertTrue(c1.equals(new Carte(ValeurCarte.V_3, SorteCarte.CARREAU)));
	}

	@Test
	public void testConsulterDessus() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

}
