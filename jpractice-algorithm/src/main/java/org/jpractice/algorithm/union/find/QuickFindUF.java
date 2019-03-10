/**
 * 
 */
package org.jpractice.algorithm.union.find;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-02 13:20:50
 * @Description: TODO
 * @version V1.0
 */
public class QuickFindUF {

    private int[] id;

    private int count; // 分量数量

    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid)
                id[i] = qid;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/xuefei/work/tinyUF.txt"));
        try {
            int N = scanner.nextInt();
            // int N = StdIn.readInt();
            QuickFindUF uf = new QuickFindUF(N);
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
