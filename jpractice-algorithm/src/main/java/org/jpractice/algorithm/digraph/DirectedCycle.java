/**
 * 
 */
package org.jpractice.algorithm.digraph;

import edu.princeton.cs.algs4.Stack;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2020-02-21 10:45:29
 * @Description: 利用深度优先搜索检测有向图是否存在环
 * @version V1.0
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    boolean hasCycle = false;

    public DirectedCycle(Digraph digraph) {
        marked = new boolean[digraph.V()];
        edgeTo = new int[digraph.V()];
        onStack = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (this.hasCycle())
                return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; v != w; x = edgeTo[x]) {
                    cycle.push(x);
                }

                cycle.push(w);
                cycle.push(v);
            }

        }
    }

    boolean hasCycle() {
        return cycle != null;
    }

    Iterable<Integer> cycle() {
        return null;
    }
}
