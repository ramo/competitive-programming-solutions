/**
 *
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	int n = arr.length;
    	int[] sorted_arr = new int[n];
    	System.arraycopy(arr, 0, sorted_arr, 0, n);
    	Arrays.sort(sorted_arr);
    	
    	Map<Integer, Integer> posMap = new HashMap<>();
    	for (int i = 0; i < n; i++) {
    		posMap.put(sorted_arr[i], i);
    	}

    	int swaps = 0;
    	int i = 0;
    	while (i < n) {
    		int j = posMap.get(arr[i]);
    		if (i == j) {
    			i++;
    			continue;
    		} else {
    			// swap
    			int temp = arr[i];
    			arr[i] = arr[j];
    			arr[j] = temp;

    			// increase the swap count
    			++swaps;
    		}
    	}

    	return swaps;
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

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
