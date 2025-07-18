import java.util.Stack;
public class DeleteMiddleOfStack{
	private static void helper(Stack<Integer> st, boolean[] flag, int[] mid){
		int top = st.pop();
		if(mid[0] > 1){
			mid[0]--;
			helper(st, flag, mid);
		}
		st.push(top);
		if(!flag[0]){
			flag[0] = true;
			st.pop();
		}
	}
	private static void removeMid(Stack<Integer> st){
		int n = st.size();
		int[] mid = {(n+1)/2};
		boolean[] flag = {false};
		helper(st, flag, mid);
	}
	 public static void main(String[] args) {
      Stack<Integer>st = new Stack<>();
      st.push(1);
      st.push(2);
      st.push(3);
      st.push(4);
      st.push(5);
      System.out.println("BEFORE Removing middle Element = "+ st.toString());
	  removeMid(st);
      System.out.println("AFTER Removing middle Element= "+ st.toString());
   }
}