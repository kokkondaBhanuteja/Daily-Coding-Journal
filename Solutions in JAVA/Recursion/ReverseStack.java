import java.util.Stack;

public class ReverseStack {
	static void helper(Stack<Integer> s, int top){
        if(s.isEmpty()){
            s.push(top);
            return;
        }
        int num = s.pop();
        helper(s, top);
        s.push(num);
    }
    static void reverse(Stack<Integer> s) {
        if(!s.isEmpty()){
            int top = s.pop();
            reverse(s);
            helper(s, top);
        }
    }

   public static void main(String[] args) {
      Stack<Integer>st = new Stack<>();
      st.push(1);
      st.push(2);
      st.push(99);
      st.push(4);
      st.push(5);
      System.out.println("BEFORE Reversing = "+ st.toString());
	  reverse(st);
      System.out.println("After Reversing = "+ st.toString());
   }
}
