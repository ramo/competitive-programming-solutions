/**
 *
 * https://www.hackerrank.com/challenges/crossword-puzzle/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=recursion-backtracking
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String[] crosswordPuzzle(String[] crossword, String words) {
        List<Slot> slots = parseSlots(crossword);
        String[] wordList = words.split(";");

        if (solve(slots, wordList, 0)) {
            char[][] grid = new char[10][10];
            assert valid(slots, grid);

            String[] result = new String[10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (grid[i][j] == '\0') {
                        grid[i][j] = crossword[i].charAt(j);
                    }
                }
                result[i] = new String(grid[i]);
            }

            return result;
        } else {
            // System.out.println("Problem has no solution.");
            return crossword;
        }
    }


    static boolean solve(List<Slot> slots, String[] words, int w) {
        if (w == words.length) {
            return true;  // base case
        }

        String word = words[w];
        boolean result = false;
        for (Slot slot : slots) {
            if (slot.isEmpty() && slot.s == word.length()) {
                slot.put(word);
                if (valid(slots) && solve(slots, words, w+1)) {
                    result = true;
                    break;
                } else {
                    // backtrack
                    slot.free();
                }
            }
        }

        return result;
    }

    static boolean valid(List<Slot> slots) {
        return valid(slots, null);
    }
    
    static boolean valid(List<Slot> slots, char[][] outGrid) {
        boolean result = true;
        char[][] grid = outGrid == null ? new char[10][10] : outGrid;
        for (Slot s : slots) {
            if (s.isEmpty()) {
                continue;
            }

            for (int i = 0; i < s.s; i++) {
                int x = s.o == 1 ? s.x : s.x+i;
                int y = s.o == 1 ? s.y+i : s.y;

                char nc = s.word.charAt(i);
                char ec = grid[x][y];

                if (ec == '\0' || ec == nc) {
                    grid[x][y] = nc;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    static List<Slot> parseSlots(String[] crossword) {
        List<Slot> slots = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int rsp = -1;
            int csp = -1;
            int rc = 0;
            int cc = 0;
            for (int j = 0; j < 10; j++) {
                if (crossword[i].charAt(j) == '-') {
                    if (rsp == -1) {
                        rsp = j;
                    }
                    ++rc;
                } else {
                    if (rsp != -1) {
                        slots.add(new Slot(i, rsp, rc, 1));
                        rsp = -1;
                        rc = 0;
                    }
                }


                if (crossword[j].charAt(i) == '-') {
                    if (csp == -1) {
                        csp = j;
                    }
                    ++cc;
                } else {
                    if (csp != -1) {
                        slots.add(new Slot(csp, i, cc, 2));
                        csp = -1;
                        cc = 0;
                    }
                }
            }

            if (rsp != -1) {
                slots.add(new Slot(i, rsp, rc, 1));
            }

            if (csp != -1) {
                slots.add(new Slot(csp, i, cc, 2));
            }
        }
        return slots;
    }

    static class Slot {
        final int x;
        final int y;
        final int s;
        final int o;
        String word;

        Slot(int x, int y, int s, int o) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.o = o;
        }

        boolean isEmpty() {
            return this.word == null;
        }

        void free() {
            this.word = null;
        }

        void put(String word) {
            assert this.word == null;
            this.word = word;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
