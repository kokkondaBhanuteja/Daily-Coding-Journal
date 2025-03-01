package bst;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> left, right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Insert method for BST
    public static TreeNode<Integer> insert(TreeNode<Integer> node, int key) {
        if (node == null) return new TreeNode<>(key);
        if (key < node.data) node.left = insert(node.left, key);
        else if (key > node.data) node.right = insert(node.right, key);
        return node;
    }

    // Utility method to print Inorder traversal
    public static void inorder(TreeNode<Integer> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
