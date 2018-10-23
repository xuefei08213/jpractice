/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-22 22:32:30
 * @Description: TODO
 * @version V1.0
 */
public class LeetCode771 {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        int[] jewels = new int[50];
        for(int i = 0;i<S.length();i++){
            String str = S.substring(i, i + 1);
            int index = hashFunc(J, str);
            if (index >= 0) {
                jewels[index]++;
            }
        }

        for (int j = 0; j < jewels.length; j++) {
            count += jewels[j];
        }

        return count;
    }

    public int numJewelsInStonesMT(String J, String S) {

        int result = 0;
        char[] cs = S.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (J.contains(cs[i] + "")) {
                result++;
            }
        }

        return result;

    }

    private int hashFunc(String J, String s) {
        return J.indexOf(s);
    }

    public static void main(String[] args) {

        LeetCode771 code771 = new LeetCode771();

        String J = "z";
        String S = "ZZ";
        System.out.println(code771.numJewelsInStones(J, S));
    }
}
