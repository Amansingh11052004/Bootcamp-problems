class Solution {
    int[][] direc = {
            { 1, 0 },
            { 0, 1 }
    };

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'X' & !visited[i][j]){
                  count++;
                  dfs(i, j, board, visited);
                   }
                }
            }
    return count;
    }
    public void dfs(int i, int j, char[][] board, boolean[][] visited){
        int n = board.length;
        int m = board[0].length;

        if(i<0 || i>=n || j<0 || j>=m) return;
        if(board[i][j] != 'X' || visited[i][j]) return;

        visited[i][j] = true;
        for(int[] d: direc){
            int ni = i + d[0];
            int nj = j + d[1];
            dfs(ni, nj, board, visited);
        }
    }
}