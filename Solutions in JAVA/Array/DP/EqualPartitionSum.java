class EqualPartitionSum{
    private boolean isPossible(int[] arr, int W) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            // because we can make sum of weight 0
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public boolean canPartition(int[] nums) {
        int targetSum  = Arrays.stream(nums).sum();
        if((targetSum&1)== 1)return false;
        return isPossible(nums, targetSum/2);
    }
}