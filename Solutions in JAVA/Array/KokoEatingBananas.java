import java.util.Arrays;
public class KokoEatingBananas {
    private static boolean isEatable(int mid, int h, int[] arr){
        int totalHour = 0;
        for(int banana: arr){
            totalHour +=Math.ceil((double)banana/mid);
        }
        return totalHour<=h;        
    }
    public static int minimumRateToEatBananas(int []arr, int h) {
        int start = 0;
        int end = Arrays.stream(arr).max().getAsInt();
        int ans = end;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isEatable(mid,h,arr)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr =new int[]{3, 6, 2, 8};
        int h = 7;
        System.out.println("The Minimum bananas that KOKO can eat in 1 Hour is  = "+minimumRateToEatBananas(arr,h));
    }
}



