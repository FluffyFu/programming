/*
 * Problem name: 100 Same Tree
 * Solve date: Wed Oct  9 22:26:05 2019
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Notes: Recursively traverse a tree and return a list that records the traverse order. Compare the lists
 *  and check if two trees are the same.
 *  When checking if two lists are equal, looping through and using get does not work out some time. The two elements
 *  are the same, but the boolean statements gives false. Using equals methods solves the problem.
 */
import java.util.ArrayList;

public class Recursive {
    ArrayList<Integer> pArray = new ArrayList<Integer>();
    ArrayList<Integer> qArray = new ArrayList<Integer>();

    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, pArray);
        traverse(q, qArray);

        if (pArray.equals(qArray)) {
            return true;
        }
        else {
            return false;
        }

    }

    private void traverse(TreeNode node, ArrayList<Integer> array) {
        if (node == null) {
            array.add(null);
            return;
        }
        array.add(node.val);
        traverse(node.left, array);
        traverse(node.right, array);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(-685);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(-685);

        Recursive rs = new Recursive();
        System.out.println(rs.isSameTree(p, q));
    }
}
