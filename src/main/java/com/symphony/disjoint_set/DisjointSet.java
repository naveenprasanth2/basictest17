package com.symphony.disjoint_set;

public class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int n) {
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    private int findLeader(int x) {
        if (parent[x] == x)
            return x;
        else {
            int leader = findLeader(parent[x]);
            parent[x] = leader;
            return leader;
        }
            
    }

    public boolean isSame(int x, int y) {
        return findLeader(x) == findLeader(y);
    }

    public void merge(int x, int y) {
        int xLeader = findLeader(x);
        int yLeader = findLeader(y);
        if (rank[xLeader] < rank[yLeader]) {
            parent[xLeader] = yLeader;
        } else {
            parent[yLeader] = xLeader;
            if (rank[xLeader] == rank[yLeader]) {
                rank[xLeader]++;
            }
        }
    }
}
