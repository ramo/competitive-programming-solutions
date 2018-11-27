/**
 *
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
 */

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        return checkBST(root, null, null);
    }
    
    boolean checkBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        
        if (min != null && root.data <= min.data) {
            return false;
        }
        
        if (max != null && root.data >= max.data) {
            return false;
        }
        
        return checkBST(root.left, min, root) && 
            checkBST(root.right, root, max);
    }
