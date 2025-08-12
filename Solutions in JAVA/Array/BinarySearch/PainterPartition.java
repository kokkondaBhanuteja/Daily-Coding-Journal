import java.util.ArrayList;
import java.util.Collections;

public class PainterPartition 
{
    private static boolean isPossible(ArrayList<Integer> arr,int mid, int K){
        int painterCount = 1; //minimum should be One
        int sum = 0;
        for(int num: arr){
            if(sum + num <= mid){
                sum +=num;
            }else{
                painterCount++;
                sum = num;
                if(painterCount > K){
                    return false;
                }
            }
        }
        return true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int start = Collections.max(boards);
        int end = boards.stream().mapToInt(Integer :: intValue).sum();
        int ans  = end;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isPossible(boards, mid, k)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }   
        return ans;
    }
	public static void main(String[] a){
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(10);ans.add(20);ans.add(30);ans.add(40);
		System.out.println(findLargestMinDistance(ans, 2));
	}
}