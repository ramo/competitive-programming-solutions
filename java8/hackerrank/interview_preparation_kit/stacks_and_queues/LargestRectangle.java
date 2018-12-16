/**
 *
 * https://www.hackerrank.com/challenges/largest-rectangle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    /**
     * Divide and conquer method
     */
    static long largestRectangle(int[] h) {
        return area(h, 0, h.length-1);
    }

    static long area(int[] h, int s, int e) {
        if (s == e) {
            return h[s];   // base case
        }

        if (s > e) {       // base case
            return 0;
        }

        int x = -1;
        int mn = Integer.MAX_VALUE;

        for (int i = s; i < e; i++) {
            if (h[i] < mn) {
                x = i;
                mn = h[i];
            }
        }

        long r1 = (long) mn * (e - s + 1);
        long r2 = area(h, s, x-1);
        long r3 = area(h, x+1, e);

        return Math.max(r1, Math.max(r2, r3));
    }


    /**
     * Enhanced stack solution. avoiding extra looping.
     */
    static long largestRectangle2(int[] h) {
        // This appending of 0 is there to support complete 
        // monotonically increasing part of the sequence.
        h = IntStream.concat(Arrays.stream(h), IntStream.of(0)).toArray();
        int n = h.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;

        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int x = stack.pop();
                int f = (stack.isEmpty() ? i : i - stack.peek() - 1);
                ans = Math.max(ans, (long) h[x] * f);
            }
        }

        return ans;
    }


    
    /**
     * solution using stack. Runtime O(n). Passed
     */
    static long largestRectangle1(int[] h) {
        int n = h.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                int e = stack.pop();
                int j = stack.isEmpty() ? -1 : stack.peek();
                int k = i;
                ans = Math.max(ans, (long) h[e] * (k - j - 1));
            }
            stack.push(i);
        }

        int k = n;
        while (!stack.isEmpty()) {
            int e = stack.pop();
            int j = stack.isEmpty() ? -1 : stack.peek();
            ans = Math.max(ans, (long) h[e] * (k - j - 1));
        }

        return ans;
    }

    /**
     * naive solution. Runtime O(n^2). Passed
     */
    static long largestRectangle0(int[] h) {
        int n = h.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && h[j] >= h[i]) {
                j--;
            }

            int k = i + 1;
            while (k < n && h[k] >= h[i]) {
                k++;
            }

            ans = Math.max(ans, (long) h[i] * (k - j - 1));
        }

        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
