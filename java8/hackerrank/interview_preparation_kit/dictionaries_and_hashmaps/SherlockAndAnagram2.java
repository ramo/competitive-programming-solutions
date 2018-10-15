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


// Solution as suggested in the editorial of the problem.
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

        Map<String, Integer> signatureMap = new HashMap<>();
        for (String str : list) {
            String sig = asciiSignature(str);
            Integer count = signatureMap.get(sig);
            if (count == null) {
                count = 0;
            }
            signatureMap.put(sig, count+1);
        }

        return signatureMap.values().stream().reduce(0, (a, b) -> a + (b * (b - 1) / 2));
    }

    static String asciiSignature(String s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++a[s.charAt(i) - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(a[i]);
            sb.append(' ');
        }
        return sb.toString().trim();
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
