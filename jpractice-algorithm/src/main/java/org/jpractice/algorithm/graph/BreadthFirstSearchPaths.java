/**
 * 
 */
package org.jpractice.algorithm.graph;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-12-10 09:36:50
 * @Description: TODO
 * @version V1.0
 */
public class BreadthFirstSearchPaths {

    private boolean[] marked; // 到达该顶点的最短路径

    private int[] edgeTo; // 到达该顶点的已知路径的最后一个顶点

    private final int s; // 起点

    public BreadthFirstSearchPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        
        while(!queue.isEmpty()) {
            // 从队列中删除第一个节点
            int v = queue.dequeue();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    queue.enqueue(w);
                    marked[w] = true;
                }
            }
        }
    }


    private boolean hasPathTo(int v) {
        return marked[s];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);

        return path;
    }

    public static void main(String[] args) {
        File file = new File("/Users/xuefei/git/jpractice/jpractice-algorithm/src/main/resources/graph/tinyCG.txt");
        Graph graph = new Graph(new In(file));
        int s = 0;
        BreadthFirstSearchPaths breadthFirstSearchPaths = new BreadthFirstSearchPaths(graph, s);

        for (int v = 0; v < graph.V(); v++) {
            StdOut.print(s + "to" + v + ": ");
            if (breadthFirstSearchPaths.hasPathTo(v)) {
                for (int x : breadthFirstSearchPaths.pathTo(v)) {
                    if (x == s)
                        StdOut.print(x);
                    else
                        StdOut.print("-" + x);
                }
                StdOut.println();
            }
        }
    }
}
