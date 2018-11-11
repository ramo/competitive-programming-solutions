/**
 *
 * https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (binarySearch(arr, k+arr[i], i+1)) {
                ++count;
            }
        }
        return count;
    }
    
    static boolean binarySearch(int[] arr, int value, int s) {
        boolean result = false;
        int e = arr.length-1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (value == arr[mid]) {
                result = true;
                break;
            } else if (value > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
