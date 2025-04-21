import java.util.*;

public class SmallestSubarraySum {
    
    public static int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int left = 0;
        long sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left++];
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 21, 7, 6, 12};
        int target = 23;
        int result = minSubArrayLen(target, arr);
        System.out.println("Smallest subarray length: " + result);
    }
}
