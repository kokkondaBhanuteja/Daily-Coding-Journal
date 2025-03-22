import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
public class HeroTest_2
{
	private static ArrayList<Integer> heroTest(int n, int k){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i =0;i<n; i++ )
		{
			arr.add(i+1);
		}
		int index = 0;
		while(!arr.isEmpty()){
			index = (index+k)%arr.size();
			ans.add(arr.get(index));
			arr.remove(index);
		}
		return ans;
	}
	public static void main(String[] args){
		int n = 6;

		int k = 3;
		System.out.println(heroTest(n,k));
	}
}