/**
 *
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=graphs
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {

        private List<List<Integer>> adjacent;
        
        public Graph(int size) {
            this.adjacent = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                this.adjacent.add(new ArrayList<>());
            }
        }

        public void addEdge(int first, int second) {
            this.adjacent.get(first).add(second);
            this.adjacent.get(second).add(first);
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int n = adjacent.size();
            boolean[] visited = new boolean[n];
            int[] d = new int[n];
            Arrays.fill(d, -1);
            
            Queue<Integer> q = new LinkedList<>();
            q.offer(startId);
            
            
            visited[startId] = true;
            d[startId] = 0;

            while (!q.isEmpty()) {
                int i = q.poll();
                for (int child : adjacent.get(i)) {
                    if (visited[child]) {
                        continue;
                    }
                    visited[child] = true;
                    d[child] = d[i] + 6;
                    q.offer(child);
                }
            }

            return d;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}

