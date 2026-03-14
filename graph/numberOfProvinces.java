class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
           if(!visited[i]){
            dfs(i, isConnected, visited);
            count++;
           }
        }
        return count;
    }
    public void dfs(int i, int[][] isConnected, boolean[] visited){
        visited[i] = true;
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(j, isConnected, visited);
            }
        }
    }
}