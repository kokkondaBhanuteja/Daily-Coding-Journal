public class Palindrome
{
	private static boolean check(String str){
		int left = 0;
		int right = str.length()-1;
		while(left < right){
			if(str.charAt(left) != str.charAt(right))return false;
			left++;
			right--;
		}
		return true;
	}
	public static boolean checkPalindrome(String str) {
		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			if(Character.isLetterOrDigit(arr[i])){
				sb.append(Character.toLowerCase(arr[i]));
			}
		}
		return check(sb.toString());
	}
	public static void main(String args[])
	{
		String str1 = "c1 O$d@eeD o1c";
		String str2 = "N2 i&nJA?a& jnI2n";
		System.out.println(checkPalindrome(str1));
		System.out.println(checkPalindrome(str2));
	}
}