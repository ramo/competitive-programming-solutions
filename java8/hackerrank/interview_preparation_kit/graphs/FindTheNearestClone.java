/**
 *
 * https://www.hackerrank.com/challenges/find-the-nearest-clone/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=graphs
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, long val) {
        // negative case
        List<Integer> myColorNodes = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            long id  = ids[i];
            if (id == val) {
                myColorNodes.add(i);
            }
        }

        if (myColorNodes.size() < 2) {
            return -1;   // there is only one node with the requested color
        }

        List<List<Integer>> g = createGraph(graphNodes, graphFrom, graphTo);
        int mn = Integer.MAX_VALUE;
        for (int v = 0; v < myColorNodes.size(); v++) {
            mn = Math.min(mn, bfs(g, myColorNodes.get(v), ids, val));
        }

        return mn;
    }

    static int bfs(List<List<Integer>> g, int v, long[] ids, long val) {
        boolean[] visited = new boolean[g.size()];
        int[] d = new int[g.size()];

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        d[v] = 0;
        int color = 0;
        int t = -1;

        while (!q.isEmpty()) {
            int c = q.poll();
            if (visited[c]) {
                continue;
            }

            if (ids[c] == val) {
                ++color; 
                if (color == 2) {  // as soon as we match the other pair
                    t = c;   // store the target
                    break;
                }
            }

            List<Integer> neighbours = g.get(c);
            for (int n : neighbours) {
                if (visited[n]) {
                    continue;
                }

                d[n] = 1 + d[c];
                q.offer(n);
            } 

            visited[c] = true;  // mark the current node as visited
        }

        int ans = Integer.MAX_VALUE;
        if (t != -1) {
            ans = d[t];
        }

        return ans;
    }




    /**
     *
     * Solved by dijkstra algo for each color nodes as source and finding min distance
     * Runtime. { V times O(E + V Log V) }
     */
    static int findShortest0(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, long val) {
        // negative case
        List<Integer> myColorNodes = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            long id  = ids[i];
            if (id == val) {
                myColorNodes.add(i);
            }
        }

        if (myColorNodes.size() < 2) {
            return -1;   // there is only one node with the requested color
        }

        List<List<Integer>> g = createGraph(graphNodes, graphFrom, graphTo);
        int mn = Integer.MAX_VALUE;
        for (int y = 0; y < myColorNodes.size(); y++) {
            mn = Math.min(mn, dijkstra(g, myColorNodes, y));
        }

        return mn;
    }

    static int dijkstra(List<List<Integer>> graph, List<Integer> myColorNodes, int y) {
        // dijkstra algo        
        int n = graph.size();
        int[] d = IntStream.range(1, n+1).map(i -> Integer.MAX_VALUE).toArray();
        boolean[] visited = new boolean[n];
        int s = myColorNodes.get(y);
        d[s] = 0;

        int i = s;
        boolean done = false;
        while (!done) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(graph.get(i).size(), (a, b) -> d[a] - d[b]); 
            for (int j : graph.get(i)) {
                d[j] = Math.min(d[j], d[i] + 1);
                pq.offer(j);
            }

            visited[i] = true;

            int ni = -1;
            while (!pq.isEmpty()) {
                ni = pq.poll();
                if (visited[ni]) {
                    ni = -1;
                } else {
                    break;
                }
            }

            if (ni == -1) {
                done = true;
                break;
            }

            i = ni;
        }

        return myColorNodes.stream().filter(x -> x != s).mapToInt(x -> d[x]).min().getAsInt();

    }

    static List<List<Integer>> createGraph(int graphNodes, int[] graphFrom, int[] graphTo) {
        List<List<Integer>> graph = new ArrayList<>(graphNodes);
        for (int i = 0; i < graphNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges
        for (int i = 0; i < graphFrom.length; i++) {
            graph.get(graphFrom[i]-1).add(graphTo[i]-1);
            graph.get(graphTo[i]-1).add(graphFrom[i]-1);
        }

        return graph;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        long val = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
