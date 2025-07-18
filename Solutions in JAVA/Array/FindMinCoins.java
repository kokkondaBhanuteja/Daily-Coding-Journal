import java.util.List;
import java.util.ArrayList;

public class FindMinCoins {
    public static List<Integer> MinimumCoins(int n) {
        int[] denominations = {1000,500,100,50,20,10,5,2,1};
        
        List<Integer> ans = new ArrayList<>();
        for(int denomination : denominations){
            while( n >= denomination){
                n-=denomination;
                ans.add(denomination);
            }
        }
        return ans;
    }
	public static void main(String[] args){
		int num = 126;
		System.out.println(MinimumCoins(num));
	}
}
