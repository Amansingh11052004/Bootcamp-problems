class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            ans = Math.min(ans, helper(0, j, matrix, dp));
        }
        return ans;
    }
    public int helper(int i, int j, int[][] matrix, int[][] dp){
        int n = matrix.length;
        if(j == n || j<0) return Integer.MAX_VALUE;
        if(i == n-1) return matrix[i][j];

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int left = helper(i+1, j-1, matrix, dp);
        int right = helper(i+1, j+1, matrix, dp);
        int down = helper(i+1, j, matrix, dp);

        return dp[i][j] = matrix[i][j] + Math.min(left, Math.min(right, down));
    }
}