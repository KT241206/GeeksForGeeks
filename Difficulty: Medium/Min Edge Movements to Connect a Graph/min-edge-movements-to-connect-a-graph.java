class Solution {
    int minEdgesReq(int n, int[][] edges) {
        if (edges.length < n - 1)
            return -1;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        int components = n;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu != pv) {
                union(parent, rank, pu, pv);
                components--;
            }
        }

        return components - 1;
    }

    int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);

        return parent[x];
    }

    void union(int[] parent, int[] rank, int a, int b) {
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }
}