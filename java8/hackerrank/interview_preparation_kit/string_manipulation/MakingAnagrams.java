/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[] al = new int[26];
        int[] bl = new int[26];
        updateLookup(a, al);
        updateLookup(b, bl);

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(al[i] - bl[i]);
        }

        return cnt;
    }

    static void updateLookup(String s, int[] lookup) {
        for (int i = 0; i < s.length(); i++) {
            ++lookup[s.charAt(i) - 'a'];
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
