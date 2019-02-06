import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 * Test class for Collinear.java
 *
 * @author
 * @version 18/09/18 12:21:26
 */
@RunWith(JUnit4.class)
public class CollinearTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new Collinear();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the two methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
		int expectedResult = 0;

		assertEquals("countCollinear failed with 3 empty arrays", expectedResult,
				Collinear.countCollinear(new int[0], new int[0], new int[0]));
		assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult,
				Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
	}

	// ----------------------------------------------------------
	/**
	 * Check for no false positives in a single-element array
	 */
	@Test
	public void testSingleFalse() {
		int[] a3 = { 15 };
		int[] a2 = { 5 };
		int[] a1 = { 10 };
		int expectedResult = 0;
		assertEquals("countCollinear({10}, {5}, {15})", expectedResult, Collinear.countCollinear(a1, a2, a3));
		///assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}

	// ----------------------------------------------------------
	/**
	 * Check for no false positives in a single-element array
	 */
	@Test
	public void testSingleTrue() {
		int[] a3 = { 15, 5 };
		int[] a2 = { 5 };
		int[] a1 = { 10, 15, 5 };
		int expectedResult = 1;
		assertEquals(
				"countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",
				expectedResult, Collinear.countCollinear(a1, a2, a3));
		/// assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3)
		///		+ ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}

	@Test
	public void binaryTestT() {
		int testInt = 4;
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		boolean expectedResult = true;
		assertEquals("binaryTest(" + Arrays.toString(a) + "," + testInt + ")", expectedResult,
				Collinear.binarySearch(a, testInt));
		testInt = 7;
		assertEquals("binaryTest(" + Arrays.toString(a) + "," + testInt + ")", expectedResult,
				Collinear.binarySearch(a, testInt));
		int testInt2 = 11;
		expectedResult = false;
		assertEquals("binaryTest(" + Arrays.toString(a) + "," + testInt2 + ")", expectedResult,
				Collinear.binarySearch(a, testInt2));
	}
	@Test
    public void testMultipleTrue(){
        int[] a3 = {2,1,9};   int[] a2 = {6,3,12};                   int[] a1 = {10,5,15};

        int expectedResult = 3;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinear(a1,a2,a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }
}
