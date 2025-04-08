import java.util.* ;
import java.io.*; 


public class BSTPairSum {
	public static void main(String[] args) {
        // Tree 1:
        //     2
        //    / \
        //   1   4
        TreeNode<Integer> root1 = new TreeNode<>(2);
        root1.left = new TreeNode<>(1);
        root1.right = new TreeNode<>(4);
		System.out.println(findTargetPair(root1,3));

    }
    private static List<Integer> inOrder(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> st = new Stack<>();
        TreeNode<Integer> temp = root;
        List<Integer> nodes = new ArrayList<>();
        while(temp != null || !st.isEmpty()){
            while(temp !=null){
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            nodes.add(temp.data);
            temp = temp.right;
        }
        return nodes;
    }

    public static boolean findTargetPair(TreeNode<Integer> root, int target) {
        List<Integer> nums = inOrder(root);
        int left = 0;
        int right = nums.size()-1;
        while(left < right){
            int sum = nums.get(left) + nums.get(right);
            if(target > sum){
                left++;
            }
            else if(sum > target){
                right--;
            }
            else{
                return true;
            }
        }
        return false;
    }
	
}
//************************************************************/

//    Following is the TreeNode class structure
    class TreeNode<T>
    {
      public  T data;
      public TreeNode<T> left;
      public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

//************************************************************/
