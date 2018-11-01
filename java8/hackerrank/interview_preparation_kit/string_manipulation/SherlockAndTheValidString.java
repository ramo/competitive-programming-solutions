/**
 *
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static boolean isValid(String s) {
        
        // Get the character frequencies
        int[] fm = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++fm[s.charAt(i) - 'a'];
        }
        
        // frequency -> chracter count map
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (fm[i] == 0) {
                continue;
            }
            
            Integer c = countMap.get(fm[i]);
            if (c == null) {
                c = 0;
            }
            countMap.put(fm[i], c+1);
        }
        
        Set<Integer> keys = countMap.keySet();
        
        // ideally we would expect 0, 1 group
        boolean result = (keys.size() < 2);
        
        // atmost we can go with group of 2
        if (keys.size() == 2) {
            Iterator<Integer> it = keys.iterator();
            // frequencies
            int a = it.next();
            int b = it.next();
            
            // characters in these frequencies
            int ac = countMap.get(a);
            int bc = countMap.get(b);
            
            // We have option to delete 1 character
            if (ac == 1 && bc == 1) {
                // If we have only 2 character races
                int mn = Math.min(a, b);
                int mx = Math.max(a, b);

                // we can destroy the min or reduce the max to min
                result = (mn == 1 || mx - mn == 1);
            } else if (ac == 1 || bc == 1) {
                
                // we have one single race on one side and
                // many races on the other side.
                // Choose the single race and try to destroy it
                // or convert it to fit the rest of the group.
                if (ac == 1) {
                    result = (a == 1 || a - b == 1);
                } else {
                    result = (b == 1 || b - a == 1);
                }
            }
        }
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        String result = isValid(s) ? "YES" : "NO";
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
