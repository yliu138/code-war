package codewar;

import com.codewar.lib.BinarySearch;
import com.codewar.lib.MergeSort;
import com.codewar.lib.Printer;

public class findElemLarger {
	public static void main(String[] args) {
		int[] ar = {6, 1, 7, 8, 2};
		int[] br = {0, 3, 4, 7};
		int[] result = new int[br.length];
		
//		To sort the ar first Time complexity: O(nlogn)
		MergeSort.sort(ar, 0, ar.length - 1);
		
//		To find the index of the first number that is larger than br[index]
//		Time complexity: O(mlogn)
		for (int i = 0; i < br.length; i++) {
			int num = br[i];
			
			int index = BinarySearch.modifiedBinarySearch(ar, num, 0, ar.length);
			if (index < 0) result[i] = 0;
			else result[i] = index;
		}
		
		Printer.printAr(result);
	}
}
