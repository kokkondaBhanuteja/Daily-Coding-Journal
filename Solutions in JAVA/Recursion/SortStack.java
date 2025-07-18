import java.util.Stack;
public class SortStack{
	private static void sortAscending(int top , Stack<Integer> st){
        if(st.isEmpty() || top > st.peek() ){
            st.push(top);
            return;
        }
        int num = st.pop();
        sortAscending(top, st);
        st.push(num);
        
    }
	
	private static void sortDescending(int top , Stack<Integer> st){
        if(st.isEmpty() || top <= st.peek() ){
            st.push(top);
            return;
        }
        int num = st.pop();
        sortDescending(top, st);
        st.push(num);
        
    }

    private static  Stack<Integer> sort(Stack<Integer> s) {
        if(!s.isEmpty()){
            int top = s.pop();
            sort(s);
            sortDescending(top, s);
        }
        return s;
    }
	 public static void main(String[] args) {
      Stack<Integer>st = new Stack<>();
      st.push(1);
      st.push(2);
      st.push(3);
      st.push(4);
      st.push(5);
      System.out.println("BEFORE Sorting Descending = "+ st.toString());
	  sort(st);
      System.out.println("After Sorting Descending = "+ st.toString());
   }

}