import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPairSumRotatedSortedArray {
    private static int getPivot(List<Integer> arr){
        int end = arr.size()-1;
        int pivot = -1;
        int start = 0;
        while(start < end){
            int mid  = start + (end-start)/2;
            if(arr.get(mid) < arr.get(mid-1)) {
                pivot = mid-1;
                break;
            }
            if(arr.get(mid) > arr.get(mid+1)){
                pivot = mid;
                break;
            }
            if( arr.get(end) < arr.get(mid)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return pivot;
    }
    public static void main(String args[]){
        List<Integer> arr;
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            arr = new ArrayList<>(n);
            for(int i=0;i<n;i++){
                arr.add(sc.nextInt());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }{}
        
    }
    
}
