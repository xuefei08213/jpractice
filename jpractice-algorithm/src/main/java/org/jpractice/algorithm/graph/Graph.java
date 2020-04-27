/**
 * 
 */
package org.jpractice.algorithm.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-12-06 23:17:30
 * @Description: TODO
 * @version V1.0
 */
public class Graph {

    private final int V; // 顶点数目

    private int E; // 边的数目

    private Bag<Integer>[] adj; // 邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt()); // 读取顶点数目并将图初始化
        int E = in.readInt(); // 读取边的数目
        
        for (int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    // 获取顶点数
    public int V() {
        return V;
    }

    // 获取边
    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); // 将w添加到v的链表中
        adj[w].add(v); // 将v添加到w的链表中
        E++;
    }

    // 获取顶点v的相邻顶点
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}
