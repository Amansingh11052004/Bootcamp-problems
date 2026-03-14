class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!bfsCheck(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfsCheck(int start, int[][] graph, int[] color){
       int n = graph.length;
       Queue<Integer> q = new LinkedList<>();
       q.add(start);
       color[start] = 0;

       while(!q.isEmpty()){
        int curr = q.poll();
        for(int neighbour : graph[curr]){
            if(color[neighbour] == -1){
                color[neighbour] = 1 - color[curr];
                q.add(neighbour);
            }

            else if(color[neighbour] == color[curr]){
                return false;
            }
        }
       }
       return true;
    }
}