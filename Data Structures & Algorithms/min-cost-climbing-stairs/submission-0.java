class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
       
        for(int i=2; i<=n; i++){
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]) ;
        }
        for(int i =0; i<dp.length; i++){
            System.out.print(dp[i] + ", ");
        }
        return dp[n];
    }
}
