import java.util.*;

public class RotateMatrixKTimes {

    public static int[][] solve(int[][] arr, int k) {
        int n = arr.length;
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int set = (k + j) % n;
                mat[i][set] = arr[i][j];
            }
        }

        return mat;
    }

    // Optional: Helper method to print the matrix (for testing)
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int k = 1;
		System.out.println("BEFORE");
		printMatrix(arr);
		System.out.println("AFTER");
        int[][] result = solve(arr, k);
        printMatrix(result);
    }
}
