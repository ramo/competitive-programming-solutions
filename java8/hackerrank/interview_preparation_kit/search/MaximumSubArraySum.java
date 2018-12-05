/**
 *
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long maximumSum(long[] a, long m) {
        int n = a.length;
        long[] prefix = new long[n];
        long cur = 0;
        for(int i = 0; i < n; i++) {
            cur = ((cur % m) + a[i]) % m;
            prefix[i] = cur;
        }

        long ans = 0;
        TreeSet<Long> st = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long prevUB = st.higher(prefix[i]);
            if ( prevUB != null) {
                ans = Math.max(ans, (prefix[i] - prevUB + m) % m);
            }
            ans = Math.max(prefix[i], ans);
            st.add(prefix[i]);
        }

        return ans;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
