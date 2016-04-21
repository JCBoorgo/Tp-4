package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cartes.Carte;
import cartes.SorteCarte;
import cartes.ValeurCarte;
import exception.ConstructeurException;

public class CarteTest {
	Carte c1, c2, c3, c4;

	@Before
	public void setUp() throws Exception {
		c1 = new Carte(ValeurCarte.V_AS, SorteCarte.PIQUE);
		c2 = new Carte(ValeurCarte.V_7, SorteCarte.CARREAU);
		c3 = new Carte(ValeurCarte.V_AS, SorteCarte.PIQUE);
		c4 = new Carte(ValeurCarte.V_AS, SorteCarte.CARREAU);
	}

	@Test
	public void testCarte() {
		try {
			Carte c5 = new Carte(null, SorteCarte.CARREAU);
			fail();
		} catch (ConstructeurException e) {}
		try {
			Carte c6 = new Carte(ValeurCarte.V_4, null);
			fail();
		} catch (ConstructeurException e) {}
	}

	@Test
	public void testSetVisible() {
		c1.setVisible(true);
		assertTrue(c1.estVisible());
		c1.setVisible(false);
		assertFalse(c1.estVisible());
	}

	@Test
	public void testToStringCarte() {
		c1.setVisible(true);
		System.out.println(c1.toStringCarte());
	}

	@Test
	public void testCompareTo() {
		assertTrue(c1.compareTo(c3) == 0);
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c3.compareTo(c4) > 0);
	}

	@Test
	public void testEqualsObject() {
		assertTrue(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertFalse(c3.equals(c4));
		assertFalse(c2.equals(c1));
	}

	@Test
	public void testToString() {
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}

}
