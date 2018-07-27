/**
 * 
 */
package codewar;

import com.codewar.lib.Printer;

/**
 * @author leoliu
 * Dynamic programming: fix the overlapping problem, it will not re-compute the thing that has already been computed
 */
public class DbFibnacci {
	private final int NIL = -1;
	private int[] lookup;
	
	public void init(int n) {
		this.lookup = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			this.lookup[i] = NIL;
		}
	}
	
//	Top-down method: i.e. memorization
	public int fib(int n) {
		if (this.lookup[n] == this.NIL) {
			if (n <= 1) {
				this.lookup[n] = n;
			} else {
				this.lookup[n] = fib(n-1) + fib(n-2);
			}
		}
		return this.lookup[n];
	}
	
	
//	Bottom-up method
	public int fibBottomUp(int n) {
		for (int i = 0; i < n+1; i++) {
			if (i <= 1) {
				this.lookup[i] = i;
			} else {
				this.lookup[i] = this.lookup[i-1] + this.lookup[i-2];
			}
		}
		return this.lookup[n];
	}
	
	
	public int[] getLookup() {
		return this.lookup;
	}
	
	public static void main(String[] args) {
		DbFibnacci df = new DbFibnacci();
		int n = 9;
		// Top-down method
		df.init(n);
		int result = df.fib(n);
		int[] lookup = df.getLookup();
		System.out.println(result);
		Printer.printAr(lookup);
		
		//bottom-up method
		df.init(n);
		result = df.fibBottomUp(n);
		lookup = df.getLookup();
		System.out.println(result);
		Printer.printAr(lookup);
	}
}
