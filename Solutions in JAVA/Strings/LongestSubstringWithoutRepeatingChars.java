import java.util.* ;
import java.io.*; 
public class LongestSubstringWithoutRepeatingChars
{
	public static int uniqueSubstrings(String input) 
    {
		int left =0;
		int right =0;
		int n = input.length();
		int ans = 0;
		Set<Character> set = new HashSet<>();
		while(right < n ){
			char ch = input.charAt(right);
			while(set.contains(ch)){
				set.remove(input.charAt(left));
				left++;
			}
			ans = Math.max(ans,right-left+1);
			set.add(input.charAt(right));

			right++;
		}
		return ans;

	}
	public static void main(String args[]){
		String str = "codingninjas";
		System.out.println(uniqueSubstrings(str));
	}
}
