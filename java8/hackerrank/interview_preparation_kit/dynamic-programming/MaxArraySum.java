/**
 *
 * https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dynamic-programming
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /**
     * DP solution for the recursive one. O(n)
     */
    static int maxSubsetSum(int[] arr) {
        int n = arr.length;
        int[] mx = new int[n];
        int m = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
            mx[i] = m;
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < 2) {
                dp[i] = Integer.MIN_VALUE;
                continue;
            }

            int r = arr[i] + mx[i-2];
            if (dp[i-2] != Integer.MIN_VALUE) {
                r = Math.max(r, arr[i] + dp[i-2]);
            }

            dp[i] = Math.max(r, dp[i-1]);
        }

        return dp[n-1];
    }

    
    /**
     * recursive solution (TLE)
     * call mas(arr, arr.length-1) from main method.
     */
    static int mas(int[] arr, int idx) {
        if (idx < 2) {
            return Integer.MIN_VALUE;
        }

        int mx = arr[idx-2];
        for (int i = idx-3; i >= 0; i--) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }

        int result = arr[idx] + mx;
        for (int i = idx-2; i >= 0; i--) {
            int tmp = mas(arr, i);
            if (tmp == Integer.MIN_VALUE) {
                continue;
            }
            result = Math.max(result, arr[idx] + tmp);
        }

        int tmp = mas(arr, idx-1);
        if (tmp != Integer.MIN_VALUE) {
            result = Math.max(result, tmp);
        }

        return result;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
