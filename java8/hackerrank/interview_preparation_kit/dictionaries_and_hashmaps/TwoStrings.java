/**
 * https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static boolean twoStrings(String s1, String s2) {
        int[] lookup = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ++lookup[s1.charAt(i) - 'a'];
        }

        boolean result = false;
        for (int i = 0; i < s2.length(); i++) {
            if (lookup[s2.charAt(i) - 'a'] > 0) {
                result = true;
                break;
            }
        } 

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            boolean result = twoStrings(s1, s2);

            bufferedWriter.write(result ? "YES" : "NO");
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
