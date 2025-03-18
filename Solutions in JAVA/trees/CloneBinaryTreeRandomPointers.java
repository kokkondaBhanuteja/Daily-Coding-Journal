import java.util.*;

public class CloneBinaryTreeRandomPointers {
    public static TreeNode<Integer> cloneBinaryTreeRandomPointer(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> copy = new TreeNode<>(root.data);
        copy.random = root.random;
        copy.left = cloneBinaryTreeRandomPointer(root.left);
        copy.right = cloneBinaryTreeRandomPointer(root.right);

        return copy;
    }

    public static void inorderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print("Node: " + root.data);
        if (root.random != null) {
            System.out.print(", Random: " + root.random.data);
        }
        System.out.println();
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);

        // Assigning random pointers
			root.random = root.right;
			root.left.random = root.left.right;
			root.right.random = root.left;
			root.left.left.random = root.right.right;
			root.right.right.random = root;

			System.out.println("Original Tree (Inorder with Random Pointers):");
			inorderTraversal(root);

			TreeNode<Integer> clonedRoot = cloneBinaryTreeRandomPointer(root);

			System.out.println("\nCloned Tree (Inorder with Random Pointers):");
			inorderTraversal(clonedRoot);
		}
}
	class TreeNode<T> {
    T data;
    TreeNode<T> left, right, random;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
        random = null;
    }
}

