class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int j=0; j<n; j++){
           ans = Math.min(ans, helper(0, j, m, n, grid, dp));
        }
        return ans;
    }
    public int helper(int i, int j, int m, int n, int[][] matrix, int[][] dp){
        if(j == m || j<0) return Integer.MAX_VALUE;
        if(i == n-1) return matrix[i][j];
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int col = 0; col<m; col++){
            if(col == j) continue;
            min = Math.min(min, helper(i+1, col, m, n, matrix, dp));
        }
        return dp[i][j] = min + matrix[i][j];
    }
}
