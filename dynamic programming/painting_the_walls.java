
class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n][2*n + 1];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, cost, time, dp);
    }

    public int helper(int i, int t, int[] cost, int[] time, int[][] dp) {
        int n = cost.length;
        if(t >= (n - i))  return 0;
        if(i == n)  return 1000000000;
    
        if (dp[i][t + n] != -1) {
            return dp[i][t + n];
        }

        int take = cost[i] + helper(i + 1, t + time[i], cost, time, dp);

        int skip = helper(i + 1, t - 1, cost, time, dp);

        return dp[i][t + n] = Math.min(take, skip);
    }
}