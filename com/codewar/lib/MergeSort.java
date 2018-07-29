package com.codewar.lib;

public class MergeSort {
	public static void merge(int[] ar, int l, int m, int r) {
		//to get the size of two arrays, notice that the left one contains the middle number
		int n1 = m - l + 1;
		int n2 = r - m;
		
		// Create two temp arrays
		int[] leftAr = new int[n1];
		int[] rightAr = new int[n2];
		
		// Copy the data to left and right temp array
		for (int i = 0; i < n1; i++) 
			leftAr[i] = ar[i + l];
		for (int j = 0; j < n2; j++)
			rightAr[j] = ar[j + m + 1];
		
//		Merge the temp arrays
		int i = 0, j = 0;
		
		//initial index of merged subarray array
		int k = l; //initially from the left
		while (i < n1 && j < n2) {
			if (leftAr[i] < rightAr[j]) {
				ar[k] = leftAr[i];
				i++;
			} else {
				ar[k] = rightAr[j];
				j++;
			}
			k++;	
		}
		
		// Copy remaining elements of left temp ar if any
		while (i < n1) {
			ar[k] = leftAr[i];
			i++;
			k++;
		}
		
		// Copy remaining elements of left temp ar if any
		while (j < n2) {
			ar[k] = rightAr[j];
			j++;
			k++;
		}
	}
	
	public static void sort(int[] ar, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(ar, l, m);
			sort(ar, m+1, r);
			
			MergeSort.merge(ar, l, m, r);
		}
	}
	
	public static void main(String[] args) {
		int[] ar = {6, 5, 3, 1, 8, 7, 2, 4};
		MergeSort.sort(ar, 0, ar.length - 1);
//		Arrays.sort(ar);
		Printer.printAr(ar);
	}
}
