/**
 *
 * https://www.hackerrank.com/challenges/poisonous-plants/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=stacks-queues
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
     * solution using stack. Runtime O(n)
     */
    static int poisonousPlants(int[] p) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int n = p.length;
        int[] days = new int[n];
        days[0] = 0; // First guy never dies

        for (int i = 1; i < n; i++) {
            int d = 0;
            while(!stack.isEmpty() && p[stack.peek()] >= p[i]) {
                d = Math.max(days[stack.pop()] + 1, d);
            }
            days[i] = stack.isEmpty() ? 0 : Math.max(d, 1);
            stack.push(i);
        }

        return Arrays.stream(days).max().getAsInt();
    }


    /**
     * naive solution. Runtime O(n^2)
     * But to my surprise, this solution is passing all the test cases.
     */
    static int poisonousPlants0(int[] p) {
        int n = p.length;
        int[] killer = new int[n];
        int[] days = new int[n];
        killer[0] = -1;
        days[0] = 0;
        for (int i = 1; i < n; i++) {
            int k = -1;
            int j = i-1;
            int d = 0;
            while (j >= 0) {
                if (p[i] > p[j]) {
                    k = j;
                    d = Math.max(d, 1);
                    break;
                } else {
                    if (killer[j] == -1) {
                        d = 0;
                        break;
                    } else {
                        d = Math.max(d, days[j]+1);
                        j = killer[j];
                    }
                }
            }
            killer[i] = k;
            days[i] = d;
        }

        return Arrays.stream(days).max().getAsInt();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
