class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] e: prerequisites){
            int u = e[0];
            int v = e[1];
            graph.get(v).add(u);
        }
       boolean[] visited = new boolean[numCourses];
       boolean[] rec = new boolean[numCourses];

       for(int i=0; i<numCourses; i++){
        if(!visited[i]){
            if(dfs(i, visited, rec, graph)) return false;
        }
       }
       return true;
    }
    public boolean dfs(int node, boolean[] visited, boolean[] rec, List<List<Integer>> graph){
        visited[node] = true;
        rec[node] = true;

        for(int next: graph.get(node)){
            if(!visited[next]){
                if(dfs(next, visited, rec, graph)){
                    return true;
                }
            }
                else if(rec[next]) return true;
            
        }
        rec[node] = false;
        return false;
    }
}
