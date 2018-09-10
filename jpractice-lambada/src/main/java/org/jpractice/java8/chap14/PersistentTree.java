/**
 * 
 */
package org.jpractice.java8.chap14;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-03 07:36:55
 * @Description: TODO
 * @version V1.0
 */
public class PersistentTree {

    static class Tree{
        private String key;
        
        private int val;
        
        private Tree left,right;

        public Tree(String key, int val, Tree left, Tree right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
        
        
    }
    
}
