class  AliceAndBobGame
{
	private static String helper(int num){
		String a = "Alice";
		String b = "Bob";
		if(num%5 == 1 || num%5 == 0){
			return b;
		}
		return a;
	}
	public static void main(String[] args) 
	{
		int num = 28;
		System.out.println(helper(num));
	}
}
