 public static void dfs(ArrayList<edge> graph[], int curr, boolean[] vis){
    System.out.print(curr+" ");
    vis[curr] = true;
    for(int i=0; i<graph[curr].size(); i++){
        edge e = graph[curr].get(i);
        if(vis[e.dest] == false){
          dfs(graph, e.dest, vis);
        }
    }
  }