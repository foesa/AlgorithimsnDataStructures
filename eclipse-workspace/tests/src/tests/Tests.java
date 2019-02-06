package tests;

import java.util.Arrays;

public class Tests {
	static int countCollinear(int[] a1, int[] a2, int[] a3) {
		int noOfLines = 0;
		for (int count1 = 0; count1 < a1.length; count1++) {
			for (int count2 = 0; count2 < a2.length; count2++) {
				for (int count3 = 0; count3 < a3.length; count3++) {
					int amount = ((a1[count1] * (2 - 3)) + (a2[count2] * (3 - 1)) + (a3[count3] * (1 - 2)));
					System.out.println(amount + "," + a1[count1] + "," + a2[count2] + "," + a3[count3]);
					if (amount == 0) {
						noOfLines++;
					}
				}
			}
		}
		return noOfLines;
	}

	static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
		int noOfLines = 0;
		sort(a3);
		System.out.println(Arrays.toString(a3));
		for (int count = 0; count < a1.length; count++) {
			for (int count2 = 0; count2 < a2.length; count2++) {
				int findNum = (a1[count] * (2 - 3)) + (a2[count2] * (3 - 1));
				int findnum = findNum * -1;
				System.out.println(findNum);
				if (binarySearch(a3, findNum)) {
					noOfLines++;
				}
			}
		}
		return noOfLines;
	}

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
			if (a[a.length - 1] < x || a[0]>x || start>end) {
				finished = true;
			}
		}
		return false;
	}

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

	public static void main(String[] args) {
		int[] a1 = {10,5,15 };
		int[] a2 = { 6,3,12 };
		int[] a3 = { 2,1,9 };
		int ans = countCollinearFast(a1, a2, a3);
		System.out.println(ans);
	}
}
