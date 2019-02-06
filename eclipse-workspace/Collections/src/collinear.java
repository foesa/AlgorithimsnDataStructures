// -------------------------------------------------------------------------
/**
 * This class contains only two static methods that search for points on the
 * same line in three arrays of integers.
 *
 * @author
 * @version 18/09/18 12:21:09
 */
class Collinear {

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in
	 * arrays a1, a2, a3. This method is static, thus it can be called as
	 * Collinear.countCollinear(a1,a2,a3)
	 * 
	 * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the
	 *        point (a1[i], 1) on the plain.
	 * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the
	 *        point (a2[i], 2) on the plain.
	 * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the
	 *        point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a
	 *         horizontal line.
	 *
	 *         Array a1, a2 and a3 contain points on the horizontal line y=1, y=2
	 *         and y=3, respectively. A non-horizontal line will have to cross all
	 *         three of these lines. Thus we are looking for 3 points, each in a1,
	 *         a2, a3 which lie on the same line.
	 *
	 *         Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they
	 *         are on the same line) if
	 *
	 *         x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0
	 *
	 *         In our case y1=1, y2=2, y3=3.
	 *
	 *         You should implement this using a BRUTE FORCE approach (check all
	 *         possible combinations of numbers from a1, a2, a3)
	 *
	 *         ----------------------------------------------------------
	 *
	 *
	 *         Order of Growth -------------------------
	 *
	 *         Caclulate and write down the order of growth of your algorithm. You
	 *         can use the asymptotic notation. You should adequately explain your
	 *         answer. Answers without adequate explanation will not be counted.
	 *
	 *         Order of growth: TODO
	 *
	 *         Explanation: TODO
	 */
	static int countCollinear(int[] a1, int[] a2, int[] a3) {
		int noOfLines = 0;
		for (int count1 = 0; count1 < a1.length; count1++) {
			for (int count2 = 0; count2 < a2.length; count2++) {
				for (int count3 = 0; count3 < a3.length; count3++) {
					int amount = ((a1[count1] * (2 - 3)) + (a2[count2] * (3 - 1)) + (a3[count3] * (1 - 2)));
					System.out.println(amount+","+a1[count1]+","+a2[count2]+","+a3[count3]);
					if (amount == 0) {
						noOfLines++;
					}
				}
			}
		}
		return noOfLines;
	}

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in
	 * arrays a1, a2, a3. This method is static, thus it can be called as
	 * Collinear.countCollinearFast(a1,a2,a3)
	 * 
	 * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the
	 *        point (a1[i], 1) on the plain.
	 * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the
	 *        point (a2[i], 2) on the plain.
	 * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the
	 *        point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a
	 *         horizontal line.
	 *
	 *         In this implementation you should make non-trivial use of
	 *         InsertionSort and Binary Search. The performance of this method
	 *         should be much better than that of the above method.
	 *
	 *
	 *         Order of Growth -------------------------
	 *
	 *         Caclulate and write down the order of growth of your algorithm. You
	 *         can use the asymptotic notation. You should adequately explain your
	 *         answer. Answers without adequate explanation will not be counted.
	 *
	 *         Order of Growth: TODO
	 *
	 *         Explanation: TODO
	 *
	 *
	 */
	static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
		int noOfLines = 0;
		sort(a3);
		for (int count = 0; count < a1.length; count++) {
			for (int count2 = 0; count2 < a2.length; count2++) {
				int findNum = (a1[count] * (2 - 3)) + (a2[count2] * (3 - 1));
				int findnum = findNum * -1;
				if (binarySearch(a3, findNum)) {
					noOfLines++;
				}
			}
		}
		return noOfLines;
	}

	// ----------------------------------------------------------
	/**
	 * Sorts an array of integers according to InsertionSort. This method is static,
	 * thus it can be called as Collinear.sort(a)
	 * 
	 * @param a: An UNSORTED array of integers.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 *
	 *         ----------------------------------------------------------
	 *
	 *         Order of Growth -------------------------
	 *
	 *         Caclulate and write down the order of growth of your algorithm. You
	 *         can use the asymptotic notation. You should adequately explain your
	 *         answer. Answers without adequate explanation will not be counted.
	 *
	 *         Order of Growth: N^2
	 *
	 *         Explanation: Two linear for-loops.
	 *
	 */
	static void sort(int[] a) {
		for (int j = 1; j < a.length; j++) {
			int i = j - 1;
			while (i >= 0 && a[i] > a[i + 1]) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				i--;
			}
		}
	}

	// ----------------------------------------------------------
	/**
	 * Searches for an integer inside an array of integers. This method is static,
	 * thus it can be called as Collinear.binarySearch(a,x)
	 * 
	 * @param a: A array of integers SORTED in ascending order.
	 * @param x: An integer.
	 * @return true if 'x' is contained in 'a'; false otherwise.
	 *
	 *         ----------------------------------------------------------
	 *
	 *         Order of Growth -------------------------
	 *
	 *         Caclulate and write down the order of growth of your algorithm. You
	 *         can use the asymptotic notation. You should adequately explain your
	 *         answer. Answers without adequate explanation will not be counted.
	 *
	 *         Order of Growth: TODO
	 *
	 *         Explanation: TODO
	 *
	 */
	static boolean binarySearch(int[] a, int x) {
		boolean finished = false;
		int start = 0;
		int end = a.length - 1;
		while (!finished) {
			int currentElem = ((start + end) / 2);
			if (a[currentElem] == x) {
				return true;
			} else if (a[currentElem] > x) {
				end = currentElem - 1;
			} else if (a[currentElem] < x) {
				start = currentElem + 1;
			}
			if (a[a.length - 1] < x || a[0]>x || start > end) {
				finished = true;
			}
		}
		return false;
	}

}
