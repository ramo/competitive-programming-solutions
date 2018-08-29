/**
 *
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * Yet to be solved. Still  some test cases are failing for this solution.
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

        int[] queue = new int[201]; // max value 200
        for (int i = 0; i < d-1; i++) {
            ++queue[expenditure[i]];
        }

        for (int i = d, j = 0; i < n; i++, j++) {
            ++queue[expenditure[i-1]];
            int median2;
            //Get median
            if (d % 2 == 0) { // even
                median2 = getValue(queue, d / 2) + getValue(queue, d / 2 + 1);
            } else { // odd
                median2 = 2 * getValue(queue, d / 2);
            }

            if (expenditure[i] >= median2) {
                ++notif;
            }

            --queue[expenditure[j]]; // remove the top element from the queue
        }

        return notif;
    }

    static int getValue(int[] queue, int stop) {
        int start = 0;
        int ans = -1;
        for (int i = 1; i < queue.length; i++) {
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
