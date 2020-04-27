/**
 * 
 */
package org.jpractice.algorithm.graph;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-12-06 23:34:13
 * @Description: TODO
 * @version V1.0
 */
public class DepthFirstSearch {

    private boolean[] marked;

    private int count;

    public DepthFirstSearch(Graph graph, int s) {
        marked = new boolean[graph.V()];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        Iterable<Integer> iterable = graph.adj(v);
        for (Integer s : iterable) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
