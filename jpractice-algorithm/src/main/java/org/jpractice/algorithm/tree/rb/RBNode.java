/**
 * 
 */
package org.jpractice.algorithm.tree.rb;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-11-10 09:12:56
 * @Description: TODO
 * @version V1.0
 */
public class RBNode<T extends Comparable<T>> {

    private boolean color;
    
    private T key;
    
    private RBNode<T> left;

    private RBNode<T> right;

    private RBNode<T> parent;

    public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
        super();
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    
    public T getKey() {
        return key;
    }

    public String toString() {

        return "" + key + (this.color == true ? "R" : "B");
    }

    /*************对红黑树节点x进行左旋操作 ******************/

    /*

     * 左旋示意图：对节点x进行左旋

     *     p                       p

     *    /                       /

     *   x                       y

     *  / \                     / \

     * lx  y      ----->       x  ry

     *    / \                 / \

     *   ly ry               lx ly

     * 左旋做了三件事：

     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)

     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)

     * 3. 将y的左子节点设为x，将x的父节点设为y

     */
    private void leftRotate(RBNode<T> targetNode) {

        RBNode<T> targetNodeParent = targetNode.parent;
        RBNode<T> targetNodeRight = targetNode.right;
        RBNode<T> lyNode = targetNodeRight.left;
        
        targetNode.right = lyNode;
        
        if(null != lyNode) {
            lyNode.parent = targetNode;
        }
        
        targetNodeRight.parent = targetNode.parent;
        if (targetNode.parent == null) {

        } else {
            if (targetNode == targetNodeParent.left) {
                targetNodeParent.left = targetNodeRight;
            } else if (targetNode == targetNodeParent.right) {
                targetNodeParent.right = targetNodeRight;
            }
        }
        
        targetNodeRight.left = targetNode;

        targetNode.parent = targetNodeRight;
    }

}
