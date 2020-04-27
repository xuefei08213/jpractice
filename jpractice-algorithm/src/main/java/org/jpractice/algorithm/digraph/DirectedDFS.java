/**
 * 
 */
package org.jpractice.algorithm.digraph;

import java.io.File;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2020-02-21 06:24:19
 * @Description: TODO
 * @version V1.0
 */
public class DirectedDFS {

    private boolean[] marked;

    // 在G中找到从s可达的所有顶点
    public DirectedDFS(Digraph G, int s) {

        marked = new boolean[G.V()];
        dfs(G, s);

    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked(s)) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {

        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked(w)) {
                dfs(digraph, w);
            }
        }

    }

    boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        File file = new File("/Users/xuefei/git/jpractice/jpractice-algorithm/src/main/resources/graph/tinyDG.txt");

        Digraph G = new Digraph(new In(args[0]));

        Bag<Integer> sources = new Bag<>();

        for (int i = 1; i < args.length; i++) {
            sources.add(Integer.parseInt(args[i]));
        }

        DirectedDFS reachable = new DirectedDFS(G, sources);

        for (int v = 0; v < G.V(); v++) {
            if (reachable.marked(v)) {
                StdOut.print(v + "");
            }
        }
    }

}
