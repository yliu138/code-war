package codewar;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private Suffix[] suffixes;

    /**
     * Initializes a suffix array for the given {@code text} string.
     * @param text the input string
     */
    private void init(String text) {
        int len = text.length();
        this.suffixes = new Suffix[len];
        for (int i = 0; i < len; i++)
            suffixes[i] = new Suffix(text, i);
        Arrays.sort(suffixes);
    }

    private static class Suffix implements Comparable<Suffix> {
        private final String text;
        private final int index;

        private Suffix(String text, int index) {
            this.text = text;
            this.index = index;
        }
        private int length() {
            return text.length() - index;
        }
        private char charAt(int i) {
            return text.charAt(index + i);
        }

        public int compareTo(Suffix that) {
            if (this == that) return 0;  // optimization
            int n = Math.min(this.length(), that.length());
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) < that.charAt(i)) return -1;
                if (this.charAt(i) > that.charAt(i)) return +1;
            }
            return this.length() - that.length();
        }

        public String toString() {
            return text.substring(index);
        }
    }

     public int length() {
        return suffixes.length;
    }

    public int index(int i) {
        if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
        return suffixes[i].index;
    }

    public int lcp(int i) {
        if (i < 1 || i >= suffixes.length) throw new IllegalArgumentException();
        return lcpSuffix(suffixes[i], suffixes[i-1]);
    }

    // longest common prefix of s and t
    private static int lcpSuffix(Suffix s, Suffix t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) return i;
        }
        return n;
    }

    public String select(int i) {
        if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
        return suffixes[i].toString();
    }

    /**
     * Returns the number of suffixes strictly less than the {@code query} string.
     * We note that {@code rank(select(i))} equals {@code i} for each {@code i}
     * between 0 and <em>n</em>-1.
     * @param query the query string
     * @return the number of suffixes strictly less than {@code query}
     */
    public int rank(String query) {
        int lo = 0, hi = suffixes.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = compare(query, suffixes[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    // compare query string to suffix
    private static int compare(String query, Suffix suffix) {
        int n = Math.min(query.length(), suffix.length());
        for (int i = 0; i < n; i++) {
            if (query.charAt(i) < suffix.charAt(i)) return -1;
            if (query.charAt(i) > suffix.charAt(i)) return +1;
        }
        return query.length() - suffix.length();
    }

// Complete the compute function below.
    static String compute(String s) {
        if (s.length() < 1 || s.length() > 100) {
            return "Invalid";
        }
//        this.init(s);
        
        return "";
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String res = compute(s);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
    

}
