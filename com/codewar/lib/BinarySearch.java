package com.codewar.lib;

// Assumptions:
// 1. all the input array given must be sorted increasingly
public class BinarySearch {
	
	public static int binarySearch(int[] ar, int val, int l, int r) {
		int m = (l + r) /2;
		
		if (l > r) {
			return -1;
		}
		
		if (ar[m] == val) {
			return m;
		} else if (ar[m] > val) {
			return binarySearch(ar, val, l, m - 1);
		} else {
			return binarySearch(ar, val, m + 1, r);
		}
	}
	
//	Return the last index that is greater than or equal to the val
	public static int modifiedBinarySearch(int[] ar, int val, int l, int r) {
		int m = (l + r) / 2;
//		the exit status
		if (l > r) {
			if (r < 0) return -1;
			if (l > ar.length - 1) return l;
			return l;
		}
		
		if (ar[m] == val) {
			return m;
		} else if (val < ar[m]) {
			return modifiedBinarySearch(ar, val, l, m - 1);
		} else {
			return modifiedBinarySearch(ar, val, m + 1, r);
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] ar = {1, 2, 6, 7, 8, 11};
		
		int index = BinarySearch.binarySearch(ar, 16, 0, ar.length - 1);
		int index2 = BinarySearch.modifiedBinarySearch(ar, 7, 0, ar.length - 1);
		System.out.println(index2);
	}
}
