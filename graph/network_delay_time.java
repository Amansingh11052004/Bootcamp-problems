class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        int m = times.length;
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: times){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, k});
        while(!q.isEmpty()){
            int[] top = q.poll();
            int time = top[0];
            int node = top[1];
            
            if(time > dist[node]) continue;
            
            for(int[] next : graph.get(node)){
                int child = next[0];
                int delay = next[1];

                if(dist[node] + delay < dist[child]){
                    dist[child] = dist[node] + delay;
                    q.add(new int[]{dist[child], child});
                }
            }
        }
    int ans = 0;
    for(int i=1; i<=n; i++){
    if(dist[i] == Integer.MAX_VALUE) return -1;
     ans = Math.max(ans, dist[i]);
       }
       return ans;
    }
}