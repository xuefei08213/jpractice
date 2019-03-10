/**
 * 
 */
package org.jpractice.algorithm.union.find;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-09 06:04:11
 * @Description: TODO
 * @version V1.0
 */
public class SocialNetworkConnectivity {

    private WeightedQuickUnionUF weightedQuickUnionUF;

    private FileInputStream fileInputStream;

    public SocialNetworkConnectivity(int nums, FileInputStream fileInputStream) {
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(nums);
        this.fileInputStream = fileInputStream;
    }

    private String getEarliestTime() {
        String earliestTimestamp = "";
        Scanner scanner = new Scanner(fileInputStream);
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (null != line && !line.trim().equals("")) {
                    String[] lineArrays = line.split(" ");
                    if (lineArrays.length == 3) {
                        String timestamp = lineArrays[0];
                        int p = Integer.parseInt(lineArrays[1]);
                        int q = Integer.parseInt(lineArrays[2]);
                        if (!weightedQuickUnionUF.connected(p, q)) {
                            weightedQuickUnionUF.union(p, q);
                            if (weightedQuickUnionUF.count() == 1) {
                                earliestTimestamp = timestamp;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            scanner.close();
        }
        return earliestTimestamp;
    }

    public static void main(String[] args) {
        FileInputStream ins;
        try {
            ins = new FileInputStream("socialNetworkLog.txt");
            SocialNetworkConnectivity networkConnectivity = new SocialNetworkConnectivity(10, ins);
            String earliestConnTime = networkConnectivity.getEarliestTime();
            System.out.println(" the earliest connected time is :" + earliestConnTime);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
