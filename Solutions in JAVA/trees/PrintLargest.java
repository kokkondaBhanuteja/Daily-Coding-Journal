import java.util.*;



public class PrintLargest {
    
    // Comparator to sort numbers in order to form the largest concatenated number
    static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2); // Sorting in descending order
        }
    }

    // Inorder traversal to collect node values
    static void inorderTraversal(BinaryTreeNode<Integer> root, List<String> nums) {
        if (root == null) {
            return;
        }
        nums.add(String.valueOf(root.data));
        inorderTraversal(root.left, nums);
        inorderTraversal(root.right, nums);
    }

    // Function to form the largest concatenated number
    public static String printLargest(BinaryTreeNode<Integer> root) {
        List<String> nums = new ArrayList<>();
        inorderTraversal(root, nums);
        
        // Sort using the custom comparator
        nums.sort(new CustomComparator());
        
        // Concatenate sorted numbers
        StringBuilder ans = new StringBuilder();
        for (String num : nums) {
            ans.append(num);
        }
        
        // Handle edge case where all numbers are zeros
        return ans.charAt(0) == '0' ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(20);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(1);

        // Compute the largest concatenated number
        String result = printLargest(root);
        System.out.println("Largest concatenated number: " + result);
    }
}
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
