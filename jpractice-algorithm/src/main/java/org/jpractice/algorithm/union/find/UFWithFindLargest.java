/**
 * 
 */
package org.jpractice.algorithm.union.find;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-09 06:52:13
 * @Description: TODO
 * @version V1.0
 */
public class UFWithFindLargest {

    private int[] id;

    private int[] sz;

    private int[] large;

    public UFWithFindLargest(int N) {
        id = new int[N];
        sz = new int[N];
        large = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
            sz[i] = 1;
            large[i] = i;
        }
    }

    private int root(int p) {

        while (id[p] != p) {
            id[p] = id[id[p]]; // path compression
            p = id[p];
        }
        return p;
    }

    // return the largest element in the connected component containing p
    public int find(int p) {
        return large[root(p)];
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq)
            return;
        int largestP = large[rootp];
        int largestQ = large[rootq];
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];

            if (largestP > largestQ)
                large[rootq] = largestP;
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];

            if (largestQ > largestP)
                large[rootp] = largestQ;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        UFWithFindLargest uf = new UFWithFindLargest(10);
        uf.union(0, 2);
        uf.union(8, 4);
        StdOut.println(uf.find(0) == 2);
        StdOut.println(uf.find(4) == 8);
        uf.union(0, 4);
        StdOut.println(uf.find(0) == 8);
        StdOut.println(uf.find(2) == 8);
        uf.union(0, 6);
        StdOut.println(uf.find(6) == 8);
        uf.union(1, 9);
        uf.union(1, 2);
        StdOut.println(uf.find(4) == 9);
    }
}
