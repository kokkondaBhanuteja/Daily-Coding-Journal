import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class KthDigit {

    private static List<Integer> getPower(int base, int exponent) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 0; i < exponent; i++) {
            ans = multiply(ans, base);
        }
        return ans;
    }

    private static List<Integer> multiply(List<Integer> ans, int base) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for (int digit : ans) {
            int num = digit * base + carry;
            result.add(num % 10);
            carry = num / 10;
        }
        while (carry != 0) {
            result.add(carry % 10);
            carry /= 10;
        }
        return result;
    }

    public static int findKthFromRight(int n, int m, int k) {
        List<Integer> ans = getPower(n, m);
        return ans.get(k - 1); // kth from right is (k-1)th in reversed list
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in);){
			int n = sc.nextInt();  // base
			int m = sc.nextInt();  // exponent
			int k = sc.nextInt();  // kth digit from right

			int result = findKthFromRight(n, m, k);
			System.out.println(result);
		}catch(Exception e){
			System.out.println("**********");
			System.out.println("Please ! Enter a Valid Kth digit it crossed the number Length!!");
			System.out.println("**********");
			e.printStackTrace();
		}
    }
}
