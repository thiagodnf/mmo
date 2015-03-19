package mmo.solution.test;

import static org.junit.Assert.*;
import mmo.solution.Solution;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSumTwoSolutions() {
		Solution a = new Solution(null, new Object[] { 5.0, 9.0, -10.0 });
		Solution b = new Solution(null, new Object[] { 17.0, -3.0, -2.0 });

		Solution result = a.sum(b);

		// Should return the correct value
		assertEquals(22.0, result.getValue(0));
		assertEquals(6.0, result.getValue(1));
		assertEquals(-12.0, result.getValue(2));
	}

	@Test
	public void testSubtractTwoSolutions() {
		Solution a = new Solution(null, new Object[] { 18.0, 5.0, 3.0 });
		Solution b = new Solution(null, new Object[] { -10.0, 9.0, -10.0 });

		Solution result = a.minus(b);

		// Should return the correct value
		assertEquals(28.0, result.getValue(0));
		assertEquals(-4.0, result.getValue(1));
		assertEquals(13.0, result.getValue(2));
	}

	@Test
	public void testMultiplyTwoSolutions() {
		Solution a = new Solution(null, new Object[] { 2.0, 3.0, 4.0 });
		Solution b = new Solution(null, new Object[] { 2.0, 3.0, 4.0 });

		Solution result = a.multiply(b);

		// Should return the correct value
		assertEquals(4.0, result.getValue(0));
		assertEquals(9.0, result.getValue(1));
		assertEquals(16.0, result.getValue(2));
	}

	@Test
	public void testMultiplyNumberBySolution() {
		Solution a = new Solution(null, new Object[] { 5.0, 6.0, 7.0 });

		Solution result = a.multiply(2);

		// Should return the correct value
		assertEquals(10.0, result.getValue(0));
		assertEquals(12.0, result.getValue(1));
		assertEquals(14.0, result.getValue(2));
	}

	@Test
	public void testSimpleOperation() {
		Solution u = new Solution(null, new Object[] { -1.0, 3.0 });
		Solution v = new Solution(null, new Object[] { 4.0, 7.0 });

		Solution result = u.multiply(2.0).minus(v);

		// Should return the correct value
		assertEquals(-6.0, result.getValue(0));
		assertEquals(-1.0, result.getValue(1));
	}
}
