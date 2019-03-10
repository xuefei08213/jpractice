/**
 * 
 */
package org.jpractice.algorithm.union.find;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-03 12:31:11
 * @Description: TODO
 * @version V1.0
 */
public class WeightedQuickUnionUF {

    private int[] id;

    private int[] size;

    private int count; // 分量数量

    /**
     * 每个触点对应的id[]元素都是同一个分量中的另一个触点（也可能是它自己） 父子关系，最终形成一棵树
     * 在输入的整数对是有序对0-1、0-2、0-3...0-N-1
     * 
     * @param N
     */
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }

        count--;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/xuefei/work/tinyUF.txt"));
        try {
            int N = scanner.nextInt();
            // int N = StdIn.readInt();
            WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
            printID(uf.id);
            while (scanner.hasNextLine()) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.println(p + " " + q);
                    System.out.println(" ");
                    printID(uf.id);
                }
            }
            System.out.println(uf.count);
        } catch (Exception e) {

        } finally {
            scanner.close();
        }

    }

    private static void printID(int[] id) {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.print(" ");
    }

}
