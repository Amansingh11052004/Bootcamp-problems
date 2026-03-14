class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
         List<List<Integer>> graph = new ArrayList<>();
         for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
         }
         for(int[] d : dislikes){
            int u = d[0];
            int v = d[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
         }
        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!bfs(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int node, List<List<Integer>> graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        color[node] = 0;
        q.add(node);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : graph.get(curr)){
                if(color[next] == -1){
                    color[next] = 1 - color[curr];
                    q.add(next);
                }
                else if(color[next] == color[curr]){
                    return false;
                }
            }
        }
    return true;
    }
}