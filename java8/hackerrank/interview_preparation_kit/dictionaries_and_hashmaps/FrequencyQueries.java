/**
 * https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new LinkedList<>();
        Map<Integer, Integer> numberToFrequency = new HashMap<>();
        Map<Integer, Set<Integer>> frequencyToNumberSet = new HashMap<>();

        for (int[] q : queries) {
            int op = q[0];
            if (op == 1) {
                int x = q[1];
                Integer c = numberToFrequency.get(x);
                if (c == null) {
                    c = 0;
                }
                numberToFrequency.put(x, c+1);
                updateFrequency(c, c+1, x, frequencyToNumberSet);
            } else if (op == 2) {
                int y = q[1];
                Integer c = numberToFrequency.get(y);
                if (c != null) {
                    if (c-1 == 0) {
                        numberToFrequency.remove(y);
                    } else {
                        numberToFrequency.put(y, c-1);
                    }
                    updateFrequency(c, c-1, y, frequencyToNumberSet);
                }
            } else if (op == 3) {
                int z = q[1];
                Set<Integer> ns = frequencyToNumberSet.get(z);
                int ans = (ns != null && !ns.isEmpty()) ? 1 : 0;
                result.add(ans);
            }
        }

        return new ArrayList<Integer>(result);
    }

    static void updateFrequency(int of, int nf, int n, Map<Integer, Set<Integer>> frequencyToNumberSet) {
        if (of > 0) {
            Set<Integer> ns = frequencyToNumberSet.get(of);
            ns.remove(n);
            frequencyToNumberSet.put(of, ns);
        }

        if (nf > 0) {
            Set<Integer> ns = frequencyToNumberSet.get(nf);
            if (ns == null) {
                ns = new HashSet<>();
            }
            ns.add(n);
            frequencyToNumberSet.put(nf, ns);
        }
    } 



public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      List<int[]> queries = new ArrayList<>(q);
      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
      for (int i = 0; i < q; i++) {
        int[] query = new int[2];
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          query[0] = Integer.parseInt(m.group(1));
          query[1] = Integer.parseInt(m.group(2));
          queries.add(query);
        }
      }
      List<Integer> ans = freqQuery(queries);
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");
      }
    }
  }
}
