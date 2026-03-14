class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] f : flights) {
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0, 0}); 
        int[] stopsArr = new int[n];
        Arrays.fill(stopsArr, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            int stops = cur[2];

            if (node == dst) return cost;

            if (stops > k) continue;

            if (stops > stopsArr[node]) continue;
            stopsArr[node] = stops;

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int price = next[1];

                pq.add(new int[]{nextNode, cost + price, stops + 1});
            }
        }

        return -1;
    }
}