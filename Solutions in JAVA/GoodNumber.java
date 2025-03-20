import java.util.HashSet;
import java.util.Set;

public class GoodNumber{
    private static int sumOfSquares(int num){
		int sum =0;
		while(num!=0){
			int digit = num%10;
			sum+=digit*digit;
			num/=10;
		}
		return sum;
	}
	public static boolean isGoodNumber(int n) {
		Set<Integer> set = new HashSet<>();
		while(n!=1 && !set.contains(n)){
			set.add(n);
			n= sumOfSquares(n);
		}
		return n == 1;
	}
    public static void main(String[] args) {
        int num = 7;
        System.out.println(isGoodNumber(num));
    }
}