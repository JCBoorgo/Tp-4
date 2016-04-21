package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structures.liste.ListeSymetrique;

public class ListeSymetriqueTest {
	ListeSymetrique l1, l2, l3;
	//TODO

	@Before
	public void setUp() throws Exception {
		l1 = new ListeSymetrique();
		l1.add(new Integer(1));
		l1.add(new Integer(2));
		l1.add(new Integer(3));
		l2 = new ListeSymetrique();
		l2.add(new Boolean(true));
		l2.add(new Boolean(false));
		l3 = new ListeSymetrique();
		l3.add(new Integer(7));
		l3.add(new Integer(2));
		l3.add(new Integer(5));
	}

	@Test
	public void testAddIntObject() {
		l1.add(0, new Integer(4));
		assertTrue(l1.get(0).equals(new Integer(4)));
		l2.add(2, new Boolean(true));
		assertTrue(l2.get(2).equals(new Boolean(true)));
		l3.add(1, new Integer(3));
		assertTrue(l3.get(1).equals(new Integer(3)));
	}

	@Test
	public void testAddObject() {
		l1.add(new Integer(4));
		l2.add(new Boolean(true));
		l3.add(new Integer(8));
		assertTrue(l1.get(3).equals(new Integer(4)));
		assertTrue(l2.get(2).equals(new Boolean(true)));
		assertTrue(l3.get(3).equals(new Integer(8)));
	}

	@Test
	public void testClear() {
		l1.clear();
		l2.clear();
		l3.clear();
		assertTrue(l1.isEmpty());
		assertTrue(l2.isEmpty());
		assertTrue(l3.isEmpty());
	}

	@Test
	public void testIndexOf() {
		assertTrue(l1.indexOf(new Integer(2)) == 1);
		assertTrue(l2.indexOf(new Boolean(false)) == 1);
		assertTrue(l3.indexOf(new Integer(7)) == 0);
	}

	@Test
	public void testRemoveInt() {
		l1.remove(2);
		l2.remove(1);
		l3.remove(0);
		assertTrue(l1.toString().equals("1, 2, "));
		assertTrue(l2.toString().equals("true, "));
		assertTrue(l3.toString().equals("2, 5, "));
	}

	@Test
	public void testRemoveObject() {
		l1.remove(new Integer(3));
		l2.remove(new Boolean(false));
		l3.remove(new Integer(7));
		System.out.println(l1.toString());
		assertTrue(l1.toString().equals("1, 2, "));
		assertTrue(l2.toString().equals("true, "));
		assertTrue(l3.toString().equals("2, 5, "));
	}

	@Test
	public void testSet() {
		l1.set(2, new Integer(4));
		l2.set(1, new Boolean(true));
		l3.set(0, new Integer(9));
		assertTrue(l1.toString().equals("1, 2, 4, "));
		assertTrue(l2.toString().equals("true, true, "));
		assertTrue(l3.toString().equals("9, 2, 5, "));
	}

	@Test
	public void testToString() {
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		System.out.println(l3.toString());
	}

}
