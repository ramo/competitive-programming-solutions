/**
 *
 * https://www.hackerrank.com/challenges/min-max-riddle/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=stacks-queues
 *   (Stock span problem) 
 *   O(n) solution
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Solution {

    static long[] riddle(long[] arr) {
        Map<Long, Integer> mm = process(arr);
        Map<Integer, Long> rm = new HashMap<>();
        for (Iterator<Long> it = mm.keySet().iterator(); it.hasNext();) {
            Long key = it.next();
            Integer value = mm.get(key);
            Long prevKey = rm.get(value);
            if (prevKey == null || prevKey < key) {
                rm.put(value, key);
            }
        }

        int n = arr.length;
        long[] result = new long[n];
        result[0] = rm.get(n);  // for sure
        for (int i = 1; i < n; i++) {
            Long t = rm.get(n-i);
            result[i] = (t == null || t < result[i-1]) ? result[i-1] : t;
        }

        return reverse(result);
    }

    static long[] reverse(long[] arr) {
        int n = arr.length;
        long[] rev = new long[n];
        for (int i = 0; i < n; i++) {
            rev[i] = arr[n-i-1];
        }
        return rev;
    }

    static Map<Long, Integer> process(long[] arr) {
        Deque<Item> stack = new ArrayDeque<>();
        Map<Long, Integer> mm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.peek() == null) {
                stack.push(new Item(arr[i], 1));
                continue;
            }

            int counter = 0;
            while (stack.peek() != null && stack.peek().no >= arr[i]) {
                Item item = stack.pop();
                counter += item.counter;
                mm.put(item.no, counter);
            }

            stack.push(new Item(arr[i], 1+counter));
        }

        int counter = 0;
        while (!stack.isEmpty()) {
            Item item = stack.pop();
            counter += item.counter;
            mm.put(item.no, counter);
        }

        return mm;
    }

    static class Item {
        long no;
        int counter;
        Item(long no, int counter) {
            this.no = no;
            this.counter = counter;
        }
    }

   private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        long[] arr = new long[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }
        long[] res = riddle(arr);
        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));
            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
