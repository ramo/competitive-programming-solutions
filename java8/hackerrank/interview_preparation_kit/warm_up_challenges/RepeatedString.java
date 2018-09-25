import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long len = s.length();
        long ac = getAc(s, (int)len);a
        
        long ans = ac * (n / len);
        ans += getAc(s, (int)(n % len));
        
        return ans;
    }
    
    static long getAc(String s, int len) {
        long ac = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                ++ac;
            }
        }
        return ac;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
