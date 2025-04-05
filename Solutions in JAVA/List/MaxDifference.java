import java.util.*; 
import java.io.*;

public class MaxDifference {
    public static int maximumDifference(String str) {
        int[] arr = new int[str.length()];
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            arr[i] = (ch == '0') ? 1 : -1;  // Correct mapping
        }
        
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            
            if(sum < 0) {
                sum = 0; // Reset the sum if it's negative
            }
        }
        
        // Edge case: if the string is all '1's, the result should be negative
        // But as per the problem, substring must have length >= 1, so return maxSum
        return maxSum;
    }

    public static void main(String[] args) {
        String str = "11000010001";
        System.out.println("Maximum difference: " + maximumDifference(str));
    }
}
