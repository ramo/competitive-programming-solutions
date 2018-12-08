/**
 *
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    static long substrCount(int n, String s) {
        CG pg = null;
        List<CG> cgs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pg != null && pg.c == c) {
                pg.g += 1;
            } else {
                pg = new CG(c);
                cgs.add(pg);
            }
        }

        int m = cgs.size();
        long ans = 0;

        for (int i = 0; i < m; i++) {
            CG cur = cgs.get(i);
            ans += f(cur.g);
            if (cur.g == 1)  {
                CG left = i-1 >= 0 ? cgs.get(i-1) : null;
                CG right = i+1 < m ? cgs.get(i+1) : null;

                if (left != null && right != null) {
                    if (left.c == right.c) {
                        ans += Math.min(left.g, right.g);
                    }
                }
            }
        }

        return ans;
    }

    static long f(long n) {
        if (n == 1) {
            return n;
        } else {
            return n * (n+1) / 2;
        }
    }

    static class CG {
        char c;
        int g;
        CG(char c) {
            this.c = c;
            this.g = 1;
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
