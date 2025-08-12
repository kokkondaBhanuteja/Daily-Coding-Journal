import java.util.* ;
import java.io.*; 
public class reverseStringsInParentheses {
	private static String helper(String str, int[] index){
		StringBuilder sb = new StringBuilder();
		while(index[0] <str.length()){
			char ch = str.charAt(index[0]);
			index[0]++;
			if(ch == '('){
				String inner = helper(str, index);
				sb.append(new StringBuilder(inner).reverse().toString());
			}else if(ch == ')'){
				return sb.toString();	
			}else{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
    public static String reverseInParentheses(String s, int n) {
		return helper(s, new int[]{0});
	}
	public static void main(String args[]){
		String str = "((ng)ipm(ca))";
		System.out.println(reverseInParentheses(str, str.length()));
	}
}