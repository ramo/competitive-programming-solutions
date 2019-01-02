/**
 *
 * https://www.hackerrank.com/challenges/maximum-xor/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=miscellaneous
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    /**
     *
     * Solution using binary trie. Runtime O(q * log32)
     */
    static int[] maxXor(int[] arr, int[] queries) {
        BinaryTrie bt = new BinaryTrie();
        for (int a : arr) {
            bt.insert(a);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            result[i] = q ^ bt.getBestXor(q);
        }

        return result;
    }

    static String binary(int n) {
        char[] bits = new char[32];
        Arrays.fill(bits, '0');

        int i = 31;
        while (n > 0) {
            if ((n & 1) == 1) {
                bits[i] = '1';
            }
            i--;
            n = n >> 1;
        }

        return new String(bits);
    }


    static class BinaryTrie {
        final BTNode root;
        BinaryTrie() {
            this.root = new BTNode();
        }

        void insert(int value) {
            String s = binary(value);
            BTNode current = this.root;
            for (int i = 0; i < s.length(); i++) {
                int j = s.charAt(i) - '0';
                if (current.children[j] == null) {
                    current.children[j] = new BTNode();
                }
                current = current.children[j];
            }
            current.isCompleted = true;
            current.value = value;
        }


        int getBestXor(int x) {
            String s = binary(x);
            BTNode current = this.root;
            for (int i = 0; i < s.length(); i++) {
                int j = s.charAt(i) - '0';
                int jc = (j + 1) % 2;
                BTNode next = null;
                if (current.children[jc] != null) {
                    next = current.children[jc];
                } else if (current.children[j] != null) {
                    next = current.children[j];
                }
                assert next != null;
                current = next;
            }

            assert current.isCompleted && current.value != null;

            return current.value;
        }

    }

    static class BTNode {
        boolean isCompleted;
        BTNode[] children = new BTNode[2];
        Integer value;
    }



    /**
     *
     * Naive soloution. Runtime O(n^2). TLE
     */
    static int[] maxXor0(int[] arr, int[] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            for (int a : arr) {
                result[i] = Math.max(result[i], a ^ q);
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = maxXor(arr, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
