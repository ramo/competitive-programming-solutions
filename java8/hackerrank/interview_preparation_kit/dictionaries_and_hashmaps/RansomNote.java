/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	Map<String, Integer> lookup = new HashMap<>();
    	for (String m : magazine) {
    		Integer count = lookup.get(m);
    		if (count == null) {
    			count = 0;
    		}
    		lookup.put(m, ++count);
    	}

    	boolean result = true;
    	for (String n : note) {
    		Integer count = lookup.get(n);
    		if (count == null) {
    			result = false;
    			break;
    		} else {
    			if (--count == 0) {
    				lookup.remove(n);
    			} else {
    				lookup.put(n, count);
    			}
    		}
    	}

    	System.out.println(result ? "Yes" : "No");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
