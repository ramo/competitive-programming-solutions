/**
 *
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// Solution accepted. Still we can improve the solution.
public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {   // starting index of the string
            for (int j = 1; j <= n-i; j++) { //length of the string
                list.add(s.substring(i, i+j));
            }
        }

        int size = list.size();
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (isAnagram(list.get(i), list.get(j))) {
                    ++count;
                }
            }
        }

        return count;
    }

    // Assumption: only lower case letters.
    static int[] ascii(String s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++a[s.charAt(i) - 'a'];
        }
        return a;
    }

    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] s1a = ascii(s1);
        int[] s2a = ascii(s2);

        boolean result = true;
        for (int i = 0; i < 26; i++) {
            if (s1a[i] != s2a[i]) {
                result = false;
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
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
