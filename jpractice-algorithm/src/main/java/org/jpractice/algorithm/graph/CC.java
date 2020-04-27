/**
 * 
 */
package org.jpractice.algorithm.graph;

/**
 * @author xuefei 连通分量
 * 
 * 这里的实现是基于一个由顶点索引的数组id[]
 * 如果v属于第i个连通分量，则id[v] = i
 * 
 * 构造函数会找出一个未被标记的顶点并调用递归函数dfs()来标记并区分出所有和它连通的顶点
 * 如此重复直到所有的顶点都被标记区分开
 */
public class CC {

	private boolean marked[];

	private int[] id;

	private int count;

	public CC(Graph G) {

		marked = new boolean[G.V()];
		id = new int[G.V()];

		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	public boolean connected(int v,int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public int count() {
		return count;
	}

}
