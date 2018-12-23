/**
 *
 * https://www.hackerrank.com/challenges/torque-and-development/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
    	List<List<Integer>> graph = new ArrayList<>(n);
    	for (int i = 0; i < n; i++) {
    		graph.add(new ArrayList<>());  //adjacency list
    	}

    	for (int[] city : cities) {
    		graph.get(city[0]).add(city[1]);
    		graph.get(city[1]).add(city[0]);
    	}

    	boolean[] visited = new boolean[n];

    	long result = 0;
    	for (int i = 0; i < n; i++) {
    		int cc = dfs(graph, visited, i);
    		if (cc == 0) {
    			continue;
    		}

			long r1 = c_lib + (long) c_road * (cc - 1);
			long r2 = c_lib * cc;

			result += Math.min(r1, r2);
    	}

    	return result;
    }


    static int dfs(List<List<Integer>> graph, boolean[] visited, int i) {
    	if (visited[i]) {
    		return 0;
    	}

    	visited[i] = true;
    	int cc = 0;
    	for (int child : graph.get(i)) {
    		cc += dfs(graph, visited, child);
    	}
    	return 1 + cc;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem-1;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
