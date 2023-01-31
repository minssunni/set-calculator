package nz.ac.auckland.softeng281.a3;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringRelationTest {

	private StringRelation relation;
	private SetOfStrings setMembers;
	private SetOfStrings expected;

	@Before
	public void setUp() {
		setMembers = new SetOfStrings();
		relation = new StringRelation(setMembers);
		expected = new SetOfStrings();
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testReflexive() {
		relation.insertElement("1,1");
		setMembers.insertElement("1");
		assertTrue(relation.isReflexive());
	}
	
	@Test
	public void testSymmetric() {
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		assertTrue(relation.isSymmetric());
	}
	
	@Test
	public void testTransitive() {
		relation.insertElement("1,2");
		relation.insertElement("2,3");
		relation.insertElement("1,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		assertTrue(relation.isTransitive());
	}

	@Test
	public void testEquivalence() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("1,3");
		relation.insertElement("2,1");
		relation.insertElement("2,2");
		relation.insertElement("2,3");
		relation.insertElement("3,1");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		assertTrue(relation.isEquivalence());
	}
	
	@Test
	public void testEqClass() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("1,3");
		relation.insertElement("2,1");
		relation.insertElement("2,2");
		relation.insertElement("2,3");
		relation.insertElement("3,1");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		expected.insertElement ("1");
		expected.insertElement ("2");
		expected.insertElement ("3");

		assertEquals(expected, relation.eqClass("1"));
	}
	
	@Test
	public void testPartha() {
		relation.insertElement("0,0");
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		relation.insertElement("2,1");

		expected.insertElement ("0");
		expected.insertElement ("1");
		expected.insertElement ("2");

		assertTrue(!relation.isSymmetric());
	}
	
}