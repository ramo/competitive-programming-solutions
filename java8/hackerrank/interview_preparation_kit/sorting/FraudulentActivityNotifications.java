/**
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int n = expenditure.length;
        int notif = 0;

        // Using count sort algo to sort the array in O(n) time
        // That too, for n = 200 We get constant running time O(k)
        int[] queue = new int[201]; // values [0-200]
        
        // Add first d-1 elements in the queue
        for (int i = 0; i < d-1; i++) {
            ++queue[expenditure[i]];
        }

        for (int i = d, j = 0; i < n; i++, j++) {
            // To make the queue with d elements, add the i-1th element.
            ++queue[expenditure[i-1]];
            
            int median2;
            //Get median
            if (d % 2 == 0) { // even
                median2 = getValue(queue, d / 2) + getValue(queue, d / 2 + 1);
            } else { // odd
                median2 = 2 * getValue(queue, d / 2 + 1);
            }

            // add a notification if the ith expenditure >= 2*median of the previous d entries
            if (expenditure[i] >= median2) {
                ++notif;
            }

            // remove the top element from the queue
            --queue[expenditure[j]];
        }

        return notif;
    }

    // get the stopth element in the queue
    static int getValue(int[] queue, int stop) {
        int start = 0;
        int ans = -1;
        for (int i = 0; i < queue.length; i++) {
            if (start + queue[i] >= stop) {
                ans = i;
                break;
            } else {
                start += queue[i];
            }
        }

        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];
        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }
        int result = activityNotifications(expenditure, d);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
