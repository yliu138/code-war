package codewar;

import java.util.Scanner;

import com.codewar.lib.Printer;

public class ArrayManipulation {
	
// This is the best implementation I have ever seen as it only has O(n) rather than complicated O(n^2) complexity
	static long arrayManipulation(int n, int[][] queries) {
        if (n < 3) return 0;
        long[] ar = new long[n];
//      To compute the value of difference of the sum
        for (int i = 0; i < queries.length; i++) {
            int sp = queries[i][0] - 1;
            int ep = queries[i][1] - 1;
            int addVal = queries[i][2];
            ar[sp] = ar[sp] + addVal;
            if (ep < n - 1) 
                ar[ep + 1] = ar[ep + 1] - addVal;
        }
        
        long max = ar[0];
        long tmp = ar[0];
        for (int i = 1; i < ar.length; i++) {
            tmp += ar[i];
            if (tmp > max) max = tmp;
        }
        return max;
    }

	
//	Notice that this is actually compute the difference between the one and successive one after the computation
//	This is a very smart solution, it doesn't need to store all the sum in the array as 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		        
		//This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
		long[] arr = new long[n];
		        
		int lower;
		int upper;
		long sum;

		for(int i=0;i<n;i++) arr[i]=0;

		for(int i=0;i<m;i++){
		    lower=scan.nextInt();
		    upper=scan.nextInt();
		    sum=scan.nextInt();
		    arr[lower-1]+=sum;
		    if(upper<n) arr[upper]-=sum; 
		}
		
		scan.close();
		
		Printer.printAr(arr);
		        
		long max=0;
		long temp=0;

		for(int i=0;i<n;i++){
		    temp += arr[i];
		    if(temp> max) max=temp;
		}

		System.out.println(max);
		
	}
}
