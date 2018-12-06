/**
 * https://www.hackerrank.com/challenges/abbr/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dynamic-programming
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Solution {

    static boolean abbreviation(String a, String b) {
        int n = a.length();
        int m = b.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && isLowerCase(a.charAt(i - 1));
        }

        for (int i = 1; i <= n; i++) {
            char la = a.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char lb = b.charAt(j - 1);
                if (la == lb) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (isLowerCase(la)) {
                    if (la - lb == 32) {
                        dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    // recursive solution
    static boolean validate(String a, String b) {
        if (a.isEmpty()) {
            return b.isEmpty();
        }

        if (b.isEmpty()) {
            return hasAllLowerCase(a);
        }

        char la = a.charAt(a.length() - 1);
        char lb = b.charAt(b.length() - 1);

        if (la == lb) {
            return validate(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));
        } else if (isLowerCase(la)) {
            if (la - lb == 32) {
                return validate(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)) ||
                        validate(a.substring(0, a.length() - 1), b);
            } else {
                return validate(a.substring(0, a.length() - 1), b);
            }
        } else {
            return false;
        }

    }

    static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    static boolean hasAllLowerCase(String s) {
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            if (!isLowerCase(s.charAt(i))) {
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
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b) ? "YES" : "NO";

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
