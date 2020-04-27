/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2020-02-03 14:09:15
 * @Description: TODO
 * @version V1.0
 */
public class Leetcode997 {

    public int findJudge(int N, int[][] trust) {

        int result = -1;

        int[] beleive = new int[N + 1];
        int[] beleived = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            beleive[trust[i][0]]++;
            beleived[trust[i][1]]++;
        }

        for (int j = 1; j <= N; j++) {
            if (beleived[j] == N - 1 && beleive[j] == 0) {
                result = j;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Leetcode997 leetcode997 = new Leetcode997();

        int N = 2;
        int[][] trust = { { 1, 2 } };
        
        System.out.println(leetcode997.findJudge(N, trust));

        int N1 = 3;
        int[][] trust1 = { { 1, 3 }, { 2, 3 } };
        System.out.println(leetcode997.findJudge(N1, trust1));

        int N2 = 3;
        int[][] trust2 = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        System.out.println(leetcode997.findJudge(N2, trust2));

        int N3 = 3;
        int[][] trust3 = { { 1, 2 }, { 2, 3 } };
        System.out.println(leetcode997.findJudge(N3, trust3));

        int N4 = 4;
        int[][] trust4 = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        System.out.println(leetcode997.findJudge(N4, trust4));

    }

}
