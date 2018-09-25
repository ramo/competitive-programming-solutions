/**
 *
 * https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs[]=interview-preparation-kit&playlist_slugs[]=warmup&h_r=next-challenge&h_v=zen
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int level = 0;
        int valley = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'U') {
                ++level;
                if (level == 0) {
                    ++valley;
                }
            } else {
                --level;
            }
        }
        return valley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
