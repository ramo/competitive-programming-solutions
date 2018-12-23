/**
 *
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxRegion function below.
    static int maxRegion(int n, int m, int[][] grid) {
        boolean[][] visited = new boolean[n][m];

        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, dfs(grid, visited, i, j, n, m));
            }
        }

        return result;
    }


    static int dfs(int[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        if (visited[i][j]) {
            return 0;
        }

        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};

        int result = grid[i][j];
        visited[i][j] = true;

        for (int x = 0; x < dx.length; x++) {
            for (int y = 0; y < dy.length; y++) {
                int x1 = i + dx[x];
                int y1 = j + dy[y];

                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m) {
                    if (grid[x1][y1] == 1) {
                        result += dfs(grid, visited, x1, y1, n, m);
                    }
                }
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(n, m, grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
