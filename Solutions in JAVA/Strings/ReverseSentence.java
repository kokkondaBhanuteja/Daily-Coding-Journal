public class ReverseSentence{
	private static String reverse(String str){
		String[] arr = str.split("\\s+");
		int left = 0, right = arr.length-1;
		while(left < right){
			String temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return String.join(" ", arr);

	}
	public static void main(String args[]){
		String str = "  Hello there I am  Bhanu.";
		System.out.println(reverse(str));
	}
}