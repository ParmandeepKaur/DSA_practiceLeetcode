class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n+1];

        for (int i=1; i<=n; i++){
            graph[i]=new ArrayList<>();
        }
        for (int[] road: roads){
            int u = road[0], v = road[1], w = road[2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        boolean[] vis = new boolean[n+1];
        int[] ans = {Integer.MAX_VALUE};
        dfs(1, graph, vis, ans);
        return ans[0];
    }

    private void dfs(int node, List<int[]>[] graph, boolean[] vis, int[] ans){
        vis[node]=true;
        for (int[] edge: graph[node]){
            ans[0] = Math.min(ans[0], edge[1]);

            if(!vis[edge[0]]){
                dfs(edge[0], graph, vis, ans);
            }
        }
    }
}