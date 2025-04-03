
public class MaximumPointsFromCards {
    public static int maxPoints(int[] arr, int K) {
        int N = arr.length;
        int totalSum = 0;
        
        // Compute sum of first K elements (taking from the left)
        for (int i = 0; i < K; i++) {
            totalSum += arr[i];
        }
        
        int maxScore = totalSum;
        int rightIndex = N - 1;
        
        // Start swapping elements from the end
        for (int i = K - 1; i >= 0; i--) {
            totalSum = totalSum - arr[i] + arr[rightIndex];  // Swap leftmost with rightmost
            rightIndex--;
            maxScore = Math.max(maxScore, totalSum);  // Track max sum
        }
        
        return maxScore;
    }
	public static void main(String[] args){
		int[] arr = {1, 100, 1, 1, 1, 100, 1, 1};
		int K = 3;
		System.out.println(maxPoints(arr, K)); 
	}
}
