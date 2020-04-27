/**
 * 
 */
package org.jpractice.algorithm.digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-12-14 08:20:55
 * @Description: 有向图
 * @version V1.0
 */
public class Digraph {

    private final int V;

    private int E = 0;

    // 保存边，索引为初始顶点，Bag中的值为跟这个顶点连接的顶点
    private Bag<Integer>[] adj;

    // 创建一副含有V个顶点但是没有边的有向图
    public Digraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    // 从输入流in中读取一副有向图
    public Digraph(In in) {

        this(in.readInt()); // 读取顶点数目并将图初始化
        int E = in.readInt(); // 读取边的数目

        for (int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }

    }

    // 顶点总数
    int V() {
        return V;
    }

    // 边总数
    int E() {
        return E;
    }

    // 向有向图中添加一条边
    void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    // 由v指出的边所连接的所有顶点
    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // 该图的反转图
    Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    // 对象的字符串表示
    // String toString() {
    //
    // }

}
