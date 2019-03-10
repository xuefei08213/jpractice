import edu.princeton.cs.algs4.StdIn;

/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-15 21:18:13
 * @Description: TODO
 * @version V1.0
 */
public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(randomizedQueue.dequeue());
        }
    }

}
