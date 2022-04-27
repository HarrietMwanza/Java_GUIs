/*We have to test our methods in the calculator GUI,
 * Import org.junit.Assert and org.junit.Test
 * Test for those that pass and fail, which means when the methods are done correctly and incorrectly*/

import static org.junit.Assert.*;

import org.junit.Test;

public class unittest {
	// Test pass
	// and fail for
	// each operator

	@Test
	public void testAddPass() {
		assertEquals("error in add()", 7, calculator.add(4, 3));
		assertEquals("error in add()", -4, calculator.add(-2, -2));
		assertEquals("error in add()", 3.0, calculator.add(1.5, 1.5));

	}

	@Test
	public void testAddFail() {
		assertNotEquals("error in add()", -4, calculator.add(3, -2));
	}

	@Test
	public void testSubPass() {
		assertEquals("error in sub()", 5, calculator.sub(6, 1));
		assertEquals("error in sub()", -2, calculator.sub(-3, -1));
		assertEquals("error in sub()", 0.0, calculator.sub(4.8, 4.8));
	}

	@Test
	public void testSubFail() {
		assertNotEquals("error in sub()", -4, calculator.sub(-3, -2));
		assertNotEquals("error in sub()", -2.0, calculator.sub(-3.0, -2.0));
	}

	@Test
	public void testMulPass() {
		assertEquals("error in Mul()", 6, calculator.Mul(2, 3));
		assertEquals("error in Mul()", -4, calculator.Mul(-2, 2));
		assertEquals("error in Mul()", 4.0, calculator.Mul(2.0, 2.0));
	}

	@Test
	public void testMulFail() {
		assertNotEquals("error in Mul()", -8, calculator.Mul(-3, -2));
		assertNotEquals("error in Mul()", 3.0, calculator.Mul(3.5, 2.0));
	}

	@Test
	public void testDivPass() {
		assertEquals("error in Div()", 3, calculator.Div(6, 2));
		assertEquals("error in Div()", 4, calculator.Div(8, 2));
		assertEquals("error in Div()", 3.0, calculator.Div(6.0, 2.0));
	}

	@Test
	public void testDivFail() {
		assertNotEquals("error in Div)", 4, calculator.Div(6, 3));
		assertNotEquals("error in Div)", 2.5, calculator.Div(6.2, 3.0));
	}
}
