/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-03-04 10:58:33
 * @Description: TODO
 * @version V1.0
 */
public class Board {

    private int dimension;

    private int[][] blocks;

    // construct a board from an n-by-n array of blocks
    public Board(int[][] blocks) {
        this.dimension = blocks.length;
        this.blocks = blocks;
    }

    // board dimension n
    public int dimension() {
        return dimension;
    }

    // number of blocks out of place
    public int hamming() {

        int count = 0;

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                int temp = i * dimension + j + 1;
                System.out.println(temp);
                if (temp != blocks[i][j] && blocks[i][j] != 0) {
                    count++;
                }
            }
        }

        return count;

    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int count = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                int temp = j * dimension + i + 1;
                if (blocks[i][j] == 0) {
                    count += 0;
                } else {
                    int manhattan = blocks[i][j] - temp;
                    count += manhattan;
                }
            }
        }

        return count;

    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        return null;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        return null;
    }

    public static void main(String[] args) {
        int[][] blocks = { { 8, 1, 3 }, { 4, 0, 2 }, { 7, 6, 5 } };
        Board board = new Board(blocks);
        System.out.println(board.hamming());
    }

}
