/**
 * 
 */
package org.jpractice.algorithm.graph;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-12-06 23:56:22
 * @Description: TODO
 * @version V1.0
 */
public class DepthFirstSearchPaths {

    private boolean[] marked; // 这个顶点上调用过dfs()了吗

    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点,即到该最终顶点的前一个顶点

    private final int s;

    public DepthFirstSearchPaths(Graph graph, int s) {
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int s) {

        marked[s] = true;
        for (int v : graph.adj(s)) {
            if (!marked[v]) {
                edgeTo[v] = s;
                dfs(graph, v);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
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
        DepthFirstSearchPaths depthFirstSearchPaths = new DepthFirstSearchPaths(graph, s);
        
        for(int v = 0;v<graph.V();v++) {
            StdOut.print(s + "to"+v+": ");
            if (depthFirstSearchPaths.hasPathTo(v)) {
                for (int x : depthFirstSearchPaths.pathTo(v)) {
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
