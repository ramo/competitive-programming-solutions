/**
 *
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    final static int[] possibilities = {1, 2, 3};
    final static long mod = 10000000007L;

    
    /**
     * dp approach
     */
    static long stepPerms(int n) {
        long[] steps = new long[n+1];
        steps[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int p : possibilities) {
                if (i < p) {
                    continue;
                }

                steps[i] += steps[i-p];
                steps[i] %= mod;
            }
        }

        return steps[n];
    }


    /**
     * Recursive approach with divide and conquer
     */
    static long stepPerms1(int n) {
        long[] m = new long[n+1];
        return countSteps(n, m);
    }

    static long countSteps(int n, long[] m) {
        if (n == 0 || n == 1) { // base case
            return 1L;
        }

        if (m[n] == 0) {
            long result = 0;
            for (int p : possibilities) {
                if (n < p) {
                    continue;
                }
                result += countSteps(n - p, m) % mod;
                result %= mod;
            }
            m[n] = result;
        }

        return m[n];
    }


    /**
     *
     * Recursive approach
     */
    static long stepPerms0(int n) {
        long[] m = new long[n+1];
        return step(0, n, m);
    }

    static long step(int s, int n, long[] m) {
        if (s == n) {
            return 1L;    // valid step
        }

        if (s > n) {
            return 0L;  // not a valid step
        }

        if (m[s] == 0) {
            long result = 0;
            for (int p : possibilities) {
                result += step(s+p, n, m) % mod;
                result %= mod;
            }
            m[s] = result;
        }

        return m[s];
    } 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
