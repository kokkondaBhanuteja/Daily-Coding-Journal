import java.util.* ;
import java.io.*; 
public class BigSquareSum
{
public static int largestSquareSubmatrix(int[][] mat, int n, int m, int k)
    {
        int[][] prefixSum = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                prefixSum[i][j] += mat[i-1][j-1]+
                                   prefixSum[i-1][j]+
                                   prefixSum[i][j-1]-
                                   prefixSum[i-1][j-1];

            }
        }
        int left = 0;
        int right = Math.min(n,m);
        int ans = 0;
        while(left<=right){
            int mid = left+ (right-left)/2;
            boolean isFound = false;
            for(int i=mid;i<=n;i++){
                for(int j=mid;j<=m;j++){
                    int sum = prefixSum[i][j]+
                            prefixSum[i-mid][j-mid]-
                            prefixSum[i-mid][j]-
                            prefixSum[i][j-mid];
                            if(sum <=k){
                                isFound = true;
                                break;
                            }
                }
                if(isFound)break;
            }
            if(isFound){
                ans = mid* mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return ans;
    }
	 public static void main(String[] args) {
        // Example input matrix
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int n = mat.length;      // Number of rows
        int m = mat[0].length;   // Number of columns
        int k = 15;              // Max allowed sum for submatrix
        
        // Call the function and print the result
        int result = largestSquareSubmatrix(mat, n, m, k);
        System.out.println("Largest square submatrix size: " + result);
    }
}
