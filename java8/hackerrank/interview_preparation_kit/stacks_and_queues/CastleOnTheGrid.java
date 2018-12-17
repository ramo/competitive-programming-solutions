/**
 *
 * https://www.hackerrank.com/challenges/castle-on-the-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
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
     *  traversing the graph using BFS to find the shortest path.
     */
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.length;
        Queue<Point> queue = new ArrayDeque<Point>();
        int moves = -1;
        queue.offer(new Point(startX, startY, 0));
        boolean[][] visited = new boolean[n][n];
        Point goal = new Point(goalX, goalY, -1);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (visited[p.x][p.y]) {
                continue;
            }

            if (goal.equals(p)) {
                moves = p.step;
                break;
            }
            visited[p.x][p.y] = true;
            List<Point> children = getChildren(p, grid, visited);
            for (Point child : children) {
                queue.offer(child);
            }
        }

        return moves;
    }

    static boolean updateChildren(List<Point> children, int x, int y, boolean[][] visited, String[] grid, int step) {
        // already visited
        if (visited[x][y]) {
            return true;
        }

        // valid block
        if (grid[x].charAt(y) == '.') {
            children.add(new Point(x, y, step));
            return true;
        } 

        // blocked
        return false;
    }

    static List<Point> getChildren(Point p, String[] grid, boolean[][] visited) {
        int n = grid.length;
        List<Point> children = new ArrayList<Point>();
        for (int x = p.x+1; x < n; x++) {
            if (!updateChildren(children, x, p.y, visited, grid, p.step+1)) {
                break;
            }
        }

        for (int x = p.x-1; x >= 0; x--) {
            if (!updateChildren(children, x, p.y, visited, grid, p.step+1)) {
                break;
            }
        }

        for (int y = p.y+1; y < n; y++) {
            if (!updateChildren(children, p.x, y, visited, grid, p.step+1)) {
                break;
            }
        }

        for (int y = p.y-1; y >= 0; y--) {
            if (!updateChildren(children, p.x, y, visited, grid, p.step+1)) {
                break;
            }
        }

        return children;
    }

    static class Point {
        final int x;
        final int y;
        final int step;

        Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } 

            if (o instanceof Point) {
                Point p = (Point) o;
                return this.x == p.x && this.y == p.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
