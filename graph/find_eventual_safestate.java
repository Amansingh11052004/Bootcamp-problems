class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      boolean[] visited = new boolean[n];
      boolean[] path = new boolean[n];
      boolean[] check = new boolean[n];

      for(int i=0;i<n; i++){
        if(!visited[i]){
            dfs(i,visited,path,check,graph);
        }
      }
      
      List<Integer> ans = new ArrayList<>();
      for(int i=0; i<n; i++){
        if(check[i]) ans.add(i);
      }
      return ans;
    }

    public boolean dfs(int node, boolean[] visited, boolean[] path, boolean[] check, int[][] graph){
        visited[node] = true;
        path[node] = true;

        for(int next : graph[node]){
            if(!visited[next]){
                 if(dfs(next,visited,path,check,graph)){
                    return true;
                 }
            }
            else if(path[next]){
                return true;
            }
        }
        check[node] = true;
        path[node] = false;
        return false;
    }
}
