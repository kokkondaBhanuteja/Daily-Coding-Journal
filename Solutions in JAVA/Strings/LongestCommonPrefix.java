import java.util.Arrays;

public class LongestCommonPrefix{
	public static String longestCommonPrefix(String[] strs) {
	        Arrays.sort(strs);
	        String first = strs[0];
	        String second = strs[strs.length - 1];
	        int i = 0;
	        while( i < first.length() && i < second.length() && first.charAt(i) == second.charAt(i)){
	            i++;
	        }
	        return first.substring(0,i);
	    }
	    
	public static void main(String[] args) {
		String[] strArr = {"flower","flow","flight"};
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		System.out.println(longestCommonPrefix(strArr));
		
	}
}