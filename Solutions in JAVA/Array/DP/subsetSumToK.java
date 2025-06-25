import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class subsetSumToK
{
	private static boolean helper(List<Integer> arr, int n , int k){
		boolean[][] dp = new boolean[n+1][k+1];
		for(int i=0;i<=n;i++)dp[i][0] = true;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=k;j++){
				if(arr.get(i-1) <= j){
					dp[i][j] = dp[i-1][j] || dp[i-1][j - arr.get(i-1)];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][k];
	}
	public static void main(String args[])
	{
		List<Integer> arr = new ArrayList<>(Arrays.asList(4,2 ,1, 3));
		int n = 4;
		int k = 5;
		System.out.println(helper(arr,n,k));
	}
}