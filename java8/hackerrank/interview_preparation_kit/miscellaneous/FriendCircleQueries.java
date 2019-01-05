/**
 *
 * https://www.hackerrank.com/challenges/friend-circle-queries/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=miscellaneous
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
     * Solution using Union find with weighted quick union and path compression
     * Runtime. O(q lg* q). Almost linear runtime.
     */
    static int[] maxCircle(int[][] queries) {
        int[] result = new int[queries.length];
        WeightedQuickUnionPathCompressedUF uf = new WeightedQuickUnionPathCompressedUF();
        for (int i = 0; i < queries.length; i++) {
            uf.union(queries[i][0], queries[i][1]);
            result[i] = uf.getMaxCCC();
        }
        return result;
    }


    static class WeightedQuickUnionPathCompressedUF {
        private Map<Integer, Integer> pm = new HashMap<>();
        private Map<Integer, Integer> sm = new HashMap<>();
        private int maxCCC = Integer.MIN_VALUE;

        public void union(int p, int q) {
            int rp = root(p);
            int rq = root(q);

            if (rp == rq) {   // already connected.
                return;
            }

            int sp = sm.getOrDefault(rp, 1);
            int sq = sm.getOrDefault(rq, 1);
            int st = sp + sq;

            if (sp < sq) {
                pm.put(rp, rq);
                sm.put(rq, st);
            } else {
                pm.put(rq, rp);
                sm.put(rp, st);
            }

            // update the maximum connected component size
            this.maxCCC = Math.max(this.maxCCC, st);
        }

        private int root(int i) {
            int x = i;
            while (x != pm.getOrDefault(x, x)) {
                x = pm.getOrDefault(x, x);
            }

            // x is the root. Now to path compression.
            int root = x;
            x = i;
            while(x != pm.getOrDefault(x, x)) {
                int y = x;
                x = pm.getOrDefault(x, x);
                pm.put(y, root);
            }

            return root;
        }

        public int getMaxCCC() {
            return maxCCC;
        }
    }


    /**
     * Naive solution using graph dfs. Runtime - O(n^2). TLE
     */
    static int[] maxCircle0(int[][] queries) {
        int[] result = new int[queries.length];
        Graph g = new Graph();
        for (int i = 0; i < queries.length; i++) {
            g.addEdge(queries[i][0], queries[i][1]);
            result[i] = g.maxCC();
        }
        return result;
    }

    static class Graph {
        private Map<Integer, List<Integer>> g = new HashMap<>();

        public void addEdge(int u, int v) {
            addEdge0(u, v);
            addEdge0(v, u);
        }

        private void addEdge0(int u, int v) {
            List<Integer> adjacent = g.get(u);
            if (adjacent == null) {
                adjacent = new ArrayList<>();
                g.put(u, adjacent);
            }
            adjacent.add(v);
        }

        public int maxCC() {
            final Set<Integer> visited = new HashSet<>();
            int result = g.keySet().stream().mapToInt(k -> dfs(k, visited)).max().getAsInt();
            return result;
        }

        private int dfs(int n, Set<Integer> visited) {
            if (visited.contains(n)) {
                return 0;
            }

            visited.add(n);
            List<Integer> adjacent = g.get(n);
            if (adjacent == null) {
                return 0;
            }

            int count = 1;
            for (int a : adjacent) {
                count += dfs(a, visited);
            }

            return count;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = maxCircle(queries);

        for (int i = 0; i < ans.length; i++) {
            bufferedWriter.write(String.valueOf(ans[i]));

            if (i != ans.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
