/**
 *
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        int n = cost.length;
        Wrapper[] ca = new Wrapper[n];
        for (int i = 0; i < n; i++) {
            ca[i] = new Wrapper(cost[i], i+1);
        }       
        Arrays.sort(ca);
        for (Wrapper c : ca) {
            int value = money - c.cost;
            if (value <= 0) {
                continue;
            }
            int p = findPair(value, c.index, ca);
            if (p != -1) {
                System.out.println(Math.min(p, c.index) + " " + Math.max(p, c.index));
                break;
            }
        }
    }
    
    static int findPair(int value, int excludeIndex, Wrapper[] ca) {
        int result = -1;
        int s = 0;
        int e = ca.length - 1;
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (ca[mid].cost == value && ca[mid].index != excludeIndex) {
                result = ca[mid].index;
                break;
            } else if (ca[mid].cost >= value) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        
        return result;
    } 
    
    static class Wrapper implements Comparable<Wrapper> {
        int cost;
        int index;
        Wrapper(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
        
        public int compareTo(Wrapper w) {
            return this.cost - w.cost;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
