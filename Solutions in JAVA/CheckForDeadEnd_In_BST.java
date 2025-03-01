import java.util.* ;
import java.io.*; 
/************************************************************
 * 
 * Following is the TreeNode class structure class TreeNode<T> { public: T data;
 * TreeNode<T> left; TreeNode<T> right;
 * 
 * TreeNode(T data) { this.data = data; left = null; right = null; } };
 ************************************************************/
import bst.TreeNode;
public class CheckForDeadEnd_In_BST {
    public static Boolean checkForDeadEnd(TreeNode<Integer> root,Integer
    mini, Integer maxi){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(mini+1 == root.data && maxi-1 == root.data){
                return true;
            }
            return false;
        }
        Boolean left = checkForDeadEnd(root.left,mini,root.data);
        Boolean right = checkForDeadEnd(root.right,root.data,maxi);
        return(left|right);
    }
    public static Boolean isDeadEnd(TreeNode<Integer> root) {
        // Write your code here
        return checkForDeadEnd(root,0,Integer.MAX_VALUE);
    }

	  // Driver program
    public static void main(String[] args)
    {
        /*       8
               /   \
              5    11
             /  \
            2    7
             \
              3
               \
                4 */
         // Create a BST using TreeNode's insert method
        TreeNode<Integer> root = null;
        root = TreeNode.insert(root, 8);
        root = TreeNode.insert(root, 5);
        root = TreeNode.insert(root, 2);
        root = TreeNode.insert(root, 3);
        root = TreeNode.insert(root, 7);
        root = TreeNode.insert(root, 11);
        root = TreeNode.insert(root, 4);

        // Check for dead-end in BST
        if (isDeadEnd(root))
            System.out.println("Yes, BST has a Dead End.");
        else
            System.out.println("No, BST does not have a Dead End.");
    }
}
