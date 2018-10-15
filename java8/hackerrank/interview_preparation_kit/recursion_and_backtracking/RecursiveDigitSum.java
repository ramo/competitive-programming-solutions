/**
 *
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem?h_l=interview&playlist_slugs[]=interview-preparation-kit&playlist_slugs[]=recursion-backtracking
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int superDigit(String n, int s, int e) {
        if (e == s) {
            return n.charAt(s) - '0';
        } else {
            int mid = s + (e - s) / 2;
            int val = superDigit(n, s, mid) + superDigit(n, mid+1, e);
            val %= 9;
            if (val == 0) {
                val = 9;
            }
            return val;
        }        
    }
    
    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        int val = superDigit(n, 0, n.length()-1);
        val = (val * k) % 9;
        if (val == 0) {
            val = 9;
        }
        return val;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
