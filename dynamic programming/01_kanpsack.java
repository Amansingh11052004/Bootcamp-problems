class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, W, val, wt, dp);
    }
    public int helper(int i, int W, int[] val, int[] wt, int[][] dp) {
        int n = wt.length;
        if(i >= n) return 0;
        if(dp[i][W] != -1) return dp[i][W];
        
        int take = 0;
        if(wt[i] <= W){
            take = val[i] + dp[i+1][W-wt[i]];
        }
        int nottake = dp[i+1][W];
        
        return dp[i][W] = Math.max(take, nottake);
    }
}
