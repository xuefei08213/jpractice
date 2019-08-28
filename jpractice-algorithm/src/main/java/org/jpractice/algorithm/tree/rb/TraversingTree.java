/**
 * 
 */
package org.jpractice.algorithm.tree.rb;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-14 23:38:59
 * @Description: TODO
 * @version V1.0
 */
public class TraversingTree {

    public void traversing(TreeNode treeNode) {

        if (null != treeNode) {
            System.out.println(treeNode.val);
            traversing(treeNode.left);
            traversing(treeNode.right);

        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 != null && t2 == null) {
            return t1;
        }

        if (t1 == null && t2 != null) {
            return t2;
        }

        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
        }

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    public static void main(String[] args) {
        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_2 = new TreeNode(2);
        TreeNode treeNode_3 = new TreeNode(3);

        treeNode_1.left = treeNode_3;
        treeNode_1.right = treeNode_2;

        TreeNode treeNode_5 = new TreeNode(5);
        treeNode_3.left = treeNode_5;

        TreeNode treeNode_2_2 = new TreeNode(2);
        TreeNode treeNode_2_1 = new TreeNode(1);
        TreeNode treeNode_2_3 = new TreeNode(3);

        treeNode_2_2.left = treeNode_2_1;
        treeNode_2_2.right = treeNode_2_3;

        TreeNode treeNode_2_4 = new TreeNode(4);
        treeNode_2_1.right = treeNode_2_4;

        TreeNode treeNode_2_7 = new TreeNode(7);
        treeNode_2_3.right = treeNode_2_7;

        TraversingTree traversingTree = new TraversingTree();
        // traversingTree.traversing(treeNode_1);
        traversingTree.mergeTrees(treeNode_1, treeNode_2_2);

        traversingTree.traversing(treeNode_1);
        // traversingTree.traversing(treeNode_2_2);
    }

}
