package com.mowen.algorithms.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mowen on 4/13/16.
 * 动态连通性 之  加权quick-union算法
 * 待改进点:将父类的链表缩成一个，即  路径压缩算法
 */
public class WeightedQuickUnionUF {
    private int[] parent; //父链
    private int[] rank;  //加权大小，即链长
    private int count; //联通分量的数量

    public WeightedQuickUnionUF(int N) {
        parent = new int[N];
        rank = new int[N];
        count = N;

        for(int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    private void validate(int p) {
        int N = parent.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N-1));
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) {
            return;
        }

        if(rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
            rank[rootP] += rank[rootQ];
        } else {
            parent[rootP] = rootQ;
            rank[rootQ] += rank[rootP];
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}
