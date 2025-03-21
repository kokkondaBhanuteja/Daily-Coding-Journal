import java.util.*;
public class  HillsandSoldier
{
	public static int countPairs(int n, int[] hills) {
		int ans = 0;
		for(int i=0;i<n-1;i++){
			int maxi = Integer.MIN_VALUE;
			for(int j = i+1;j<n;j++){
				if(hills[j] >= maxi && hills[i] >= maxi){
					maxi = hills[j];
					ans++;
				}
				if(hills[j] >hills[i]){break;}
				
			}
		}
		return ans;
	}
	public static void main(String args[]){
		int[] hills = {1 ,2 ,3 ,4 ,5 };
		int n = 5;
		System.out.println("The No.of Soldiers can see is = "+countPairs(n,hills));
		n = 6;
		hills = new int[]{2 ,2 ,1 ,3 ,4 ,6};
		System.out.println("The No.of Soldiers can see is = "+countPairs(n,hills));
	}
}