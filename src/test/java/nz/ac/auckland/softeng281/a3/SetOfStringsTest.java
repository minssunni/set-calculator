package nz.ac.auckland.softeng281.a3;

// YOU SHOULD ADD NEW TEST CASES

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetOfStringsTest {
	SetOfStrings set1, set2;

	@Before
	public void setUp() {
		set1 = new SetOfStrings();
		set2 = new SetOfStrings();
	}

	@After
	public void tearDown() {

	}

	/**
	@Test
	public void testUnion() {

		set1.insertElement("a");
		set2.insertElement("b");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		assertEquals(expected, set1.union(set2));
	}
	
	@Test
	public void testUnionWithMoreElements() {

		set1.insertElement("s");
		set1.insertElement("o");
		set1.insertElement("f");
		set1.insertElement("t");
		
		set2.insertElement("e");
		set2.insertElement("n");
		set2.insertElement("g");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("s");
		expected.insertElement("o");
		expected.insertElement("f");
		expected.insertElement("t");
		expected.insertElement("e");
		expected.insertElement("n");
		expected.insertElement("g");
		assertEquals(expected, set1.union(set2));
	}
	
	@Test
	public void testUnionWithSameElements() {

		set1.insertElement("s");
		set1.insertElement("o");
		set1.insertElement("f");
		set1.insertElement("t");
		
		set2.insertElement("s");
		set2.insertElement("o");
		set2.insertElement("a");
		set2.insertElement("p");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("s");
		expected.insertElement("o");
		expected.insertElement("f");
		expected.insertElement("t");
		expected.insertElement("a");
		expected.insertElement("p");
		assertEquals(expected, set1.union(set2));
	}
	
	@Test
	public void testUnionWithDifferentOrder() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		
		set2.insertElement("c");
		set2.insertElement("d");
		set2.insertElement("e");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("e");
		expected.insertElement("d");
		expected.insertElement("c");
		expected.insertElement("b");
		expected.insertElement("a");
		assertEquals(expected, set1.union(set2));
	}
	
	
	@Test
	public void testIntersection() {

		set1.insertElement("a");
		set1.insertElement("b");
		
		set2.insertElement("a");
		set2.insertElement("c");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		assertEquals(expected, set1.intersection(set2));
	}

	@Test
	public void testIntersectionWithMoreElements() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		set1.insertElement("d");
		set1.insertElement("e");
		
		set2.insertElement("a");
		set2.insertElement("n");
		set2.insertElement("g");
		set2.insertElement("e");
		set2.insertElement("l");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("e");
		assertEquals(expected, set1.intersection(set2));
	}
	
	@Test
	public void testIntersectionWithEqualSets() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		
		set2.insertElement("a");
		set2.insertElement("b");
		set2.insertElement("c");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		expected.insertElement("c");
		assertEquals(expected, set1.intersection(set2));
	}
	
	@Test
	public void testIntersectionWithDifferentOrder() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		
		set2.insertElement("a");
		set2.insertElement("c");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("c");
		expected.insertElement("a");
		assertEquals(expected, set1.intersection(set2));
	}

	@Test
	public void testDifference() {

		set1.insertElement("a");
		set1.insertElement("b");
		
		set2.insertElement("a");
		set2.insertElement("c");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("b");
		assertEquals(expected, set1.difference(set2));
	}
	
	@Test
	public void testDifferenceWithMoreElements() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		set1.insertElement("d");
		set1.insertElement("e");
		
		set2.insertElement("a");
		set2.insertElement("c");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("b");
		expected.insertElement("d");
		expected.insertElement("e");
		assertEquals(expected, set1.difference(set2));
	}
	
	@Test
	public void testDifferenceWithEqualSets() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		
		set2.insertElement("a");
		set2.insertElement("b");
		set2.insertElement("c");

		SetOfStrings expected = new SetOfStrings();
		assertEquals(expected, set1.difference(set2));
	}
	
	@Test
	public void testDifferenceWithDifferentOrder() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		set1.insertElement("d");
		set1.insertElement("e");
		
		set2.insertElement("a");
		set2.insertElement("c");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("e");
		expected.insertElement("b");
		expected.insertElement("d");
		assertEquals(expected, set1.difference(set2));
	}
	**/

}
