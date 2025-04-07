import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class MergeBST {

    // Iterative inorder traversal
    private static List<Integer> inorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            nodes.add(curr.data);
            curr = curr.right;
        }

        return nodes;
    }

    // Merge two BSTs
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> num1 = inorder(root1);
        List<Integer> num2 = inorder(root2);

        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < num1.size() && j < num2.size()) {
            if (num1.get(i) <= num2.get(j)) {
                merged.add(num1.get(i++));
            } else {
                merged.add(num2.get(j++));
            }
        }

        while (i < num1.size()) {
            merged.add(num1.get(i++));
        }

        while (j < num2.size()) {
            merged.add(num2.get(j++));
        }

        return merged;
    }

    // Main method
    public static void main(String[] args) {
        // Tree 1:
        //     2
        //    / \
        //   1   4
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        // Tree 2:
        //     3
        //    / \
        //   0   5
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(5);

        List<Integer> mergedList = mergeBST(root1, root2);
        System.out.println("Merged BST in sorted order: " + mergedList);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
