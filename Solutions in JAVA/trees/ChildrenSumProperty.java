
public class ChildrenSumProperty {

    static class Node {

        public int data;
        public Node left;
        public Node right;

        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isParentSum(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        int leftVal = (root.left != null) ? root.left.data : 0;
        int rightVal = (root.right != null) ? root.right.data : 0;

        boolean isValid = root.data == leftVal + rightVal;
        return isValid && isParentSum(root.left) && isParentSum(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(1);
        System.out.println(isParentSum(root));
    }
}
