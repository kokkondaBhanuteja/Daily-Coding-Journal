import java.util.*;

public class LongestMountainSubArray {
    public static int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0; // A mountain needs at least 3 elements
        
        int maxLen = 0;

        for (int i = 1; i < n - 1; i++) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand left while elements are increasing
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Expand right while elements are decreasing
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the length of the mountain
                int currLen = right - left + 1;
                maxLen = Math.max(maxLen, currLen);

                // Move `i` to `right` to skip unnecessary checks
                i = right;
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 4};
        System.out.println(longestMountain(arr)); // Output: 3
    }
}
