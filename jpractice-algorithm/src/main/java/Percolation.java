import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-10 05:13:35
 * @Description: TODO
 * @version V1.0
 */
public class Percolation {

    private int gridLength = 0;

    private boolean[] isOpen;

    private WeightedQuickUnionUF percolation;

    private WeightedQuickUnionUF fullness;

    private int virtualTopIndex;

    private int virtualBottomIndex;

    private int count;


    /// converts between two dimensional coordinate system and site array index.
    /// throws exceptions on invalid bounds. valid indices are 1 : N^2
    /// i is the row; j is the column
    private int siteIndex(int i, int j) {
        checkBounds(i, j);
        int x = j;
        int y = i;
        return (y - 1) * gridLength + (x);
    }

    /*
     * By convention, the indices i and j are integers between 1 and N, where (1, 1)
     * is the upper-left site: Throw a java.lang.IndexOutOfBoundsException if either
     * i or j is outside this range.
     */
    private void checkBounds(int i, int j) {
        if (i > gridLength || i < 1) {
            throw new IndexOutOfBoundsException("row index i out of bounds");
        }
        if (j > gridLength || j < 1) {
            throw new IndexOutOfBoundsException("column index j out of bounds");
        }
    }

    public Percolation(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException();
        }
        gridLength = sideLength;
        int arraySize = sideLength * sideLength + 2;
        isOpen = new boolean[arraySize];
        virtualTopIndex = 0;
        virtualBottomIndex = (sideLength * sideLength) + 1;

        isOpen[virtualTopIndex] = true; /// open virtual top site
        isOpen[virtualBottomIndex] = true; /// open virtual bottom site

        percolation = new WeightedQuickUnionUF(arraySize);
        fullness = new WeightedQuickUnionUF(arraySize);
        for (int j = 1; j <= sideLength; j++) {
            /// connect all top row sites to virtual top site
            int i = 1;
            int topSiteIndex = siteIndex(i, j);
            percolation.union(virtualTopIndex, topSiteIndex);
            fullness.union(virtualTopIndex, topSiteIndex);

            /// connect all bottom row sites to virtual bottom site
            i = sideLength;
            int bottomSiteIndex = siteIndex(i, j);
            percolation.union(virtualBottomIndex, bottomSiteIndex);
        }
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        int siteIndex = siteIndex(i, j);
        if (!isOpen[siteIndex]) {
            /// to open a site, change boolean value, and union with any adjacent open sites
            isOpen[siteIndex] = true;
            count++;
            // before connecting to a neighbor, first check that site is not on an edge, and
            // is open
            if (j > 1 && isOpen(i, j - 1)) {
                int indexToLeft = siteIndex(i, j - 1);
                percolation.union(siteIndex, indexToLeft);
                fullness.union(siteIndex, indexToLeft);
            }

            if (j < gridLength && isOpen(i, j + 1)) {
                int indexToRight = siteIndex(i, j + 1);
                percolation.union(siteIndex, indexToRight);
                fullness.union(siteIndex, indexToRight);
            }

            if (i > 1 && isOpen(i - 1, j)) // site is not top edge
            {
                int indexToTop = siteIndex(i - 1, j);
                percolation.union(siteIndex, indexToTop);
                fullness.union(siteIndex, indexToTop);
            }

            if (i < gridLength && isOpen(i + 1, j)) /// site is not on bottom edge
            {
                int indexToBottom = siteIndex(i + 1, j);
                percolation.union(siteIndex, indexToBottom);
                fullness.union(siteIndex, indexToBottom);
            }
        }
    };

    public boolean isOpen(int row, int col) {
        int siteIndex = siteIndex(row, col);
        return isOpen[siteIndex];
    }

    public boolean isFull(int row, int col) {
        int siteIndex = siteIndex(row, col);
        // return (percolation.connected(virtualTopIndex,siteIndex) &&
        // isOpen[siteIndex]);
        return (fullness.connected(virtualTopIndex, siteIndex) && isOpen[siteIndex]);
    }

    public int numberOfOpenSites() {
        return count;
    }

    public boolean percolates() {
        if (gridLength > 1) {
            return percolation.connected(virtualTopIndex, virtualBottomIndex);
        } else {
            return isOpen[siteIndex(1, 1)];
        }
    }

    public static void main(String[] args) {

    }
}
