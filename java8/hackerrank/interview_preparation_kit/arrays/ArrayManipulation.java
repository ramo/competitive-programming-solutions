/**
 *
 * https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    /**
     * Solution using BIT. Runtime O(n log n)
     */
    static long arrayManipulation(int n, int[][] queries) {
        long[] bit = new long[n+1];
        for (int[] q : queries) {
            int a = q[0];
            int b = q[1];
            int k = q[2];
            update(bit, a, n, k);
            update(bit, b+1, n, -k);
        }

        long result = -1;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, get(bit, i));
        }

        return result;
    }

    static void update(long[] bit, int i, int n, int v) {
        while (i <= n) {
            bit[i] += v;
            i += i & (-i);
        }
    }

    static long get(long[] bit, int i) {
        long s = 0;
        while (i > 0) {
            s += bit[i];
            i -= i & (-i);
        }
        return s;
    }

    /**
     * Naive solution. Runtime O(n^2). TLE
     */
    static long arrayManipulation0(int n, int[][] queries) {
        int arr[] = new int[n];
        for (int[] q : queries) {
            int a = q[0] - 1;
            int b = q[1] - 1;
            int k = q[2];

            for (int i = a; i <= b; i++) {
                arr[i] += k;
            }
        }

        return IntStream.of(arr).max().getAsInt();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
