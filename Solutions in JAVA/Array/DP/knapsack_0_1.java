import java.util.Scanner;

public class knapsack_0_1 {
    private static int helper(int[] weights, int[] val, int W, int n) {
        if (n <= 0 || W <= 0) {
            return 0;
        }
        if (weights[n - 1] <= W) {
            return Math.max(
                val[n - 1] + helper(weights, val, W - weights[n - 1], n - 1),
                helper(weights, val, W, n - 1)
            );
        }
        return helper(weights, val, W, n - 1);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the Size of the Array = ");
            int n = sc.nextInt();
            int[] weights = new int[n];
            int[] val = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the weight of index " + i + ": ");
                weights[i] = sc.nextInt();
                System.out.print("Enter the value of index " + i + ": ");
                val[i] = sc.nextInt();
            }
            System.out.print("Enter the Capacity of Knapsack: ");
            int W = sc.nextInt();
            System.out.println("Maximum value that can be obtained: " + helper(weights, val, W, n));
        }
    }
}
