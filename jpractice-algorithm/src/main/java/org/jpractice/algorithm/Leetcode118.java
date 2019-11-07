/**
 * 
 */
package org.jpractice.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-10-18 04:33:06
 * @Description: TODO
 * @version V1.0
 */
public class Leetcode118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            generate(pascalTriangle, i);
        }
        return pascalTriangle;

    }

    private void generate(List<List<Integer>> pascalTriangle, int rowNum) {

        if (rowNum == 0 || rowNum == 1) {
            pascalTriangle.add(generateFirstTwoRow(rowNum));
        } else {
            generateRowAfterTwo(pascalTriangle, rowNum);
        }


    }

    private List<Integer> generateFirstTwoRow(int rowNum) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i <= rowNum; i++) {
            integers.add(1);
        }
        return integers;
    }

    private void generateRowAfterTwo(List<List<Integer>> pascalTriangle, int rowNum) {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);

        List<Integer> prevRow = pascalTriangle.get(rowNum - 1);
        for (int k = 0; k < (prevRow.size() - 1); k++) {
            integers.add(prevRow.get(k) + prevRow.get(k + 1));
        }
        integers.add(1);

        pascalTriangle.add(integers);

    }

    public static void main(String[] args) {
        Leetcode118 leetcode118 = new Leetcode118();
        leetcode118.generate(5);
    }

}
