/**
 * 
 */
package org.jpractice.algorithm.tree.rb;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-14 23:37:08
 * @Description: TODO
 * @version V1.0
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}
