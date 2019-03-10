import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-28 10:02:56
 * @Description: TODO
 * @version V1.0
 */
public class Point implements Comparable<Point> {

    private final int x; // x-coordinate of this point
    private final int y; // y-coordinate of this point

    // constructs the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw() {
        StdDraw.point(x, y);
    }

    // draws the line segment from this point to that point
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }


    // the slope between this point and that point
    /**
     * Returns the slope between this point and the specified point. Formally, if
     * the two points are (x0, y0) and (x1, y1), then the slope is (y1 - y0) / (x1 -
     * x0). For completeness, the slope is defined to be +0.0 if the line segment
     * connecting the two points is horizontal; Double.POSITIVE_INFINITY if the line
     * segment is vertical; and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1)
     * are equal.
     *
     * @param that
     *            the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {

        if (that == null) {
            throw new NullPointerException();
        }

        if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        }

        if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }

        if (this.y == that.y) {
            return 0;
        }

        return ((double) this.y - (double) that.y) / ((double) this.x - (double) that.x);

    }
    
    public Comparator<Point> slopeOrder() {
        return SLOPE_ORDER;
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    // compare two points by slopes they make with this point
    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate. Formally,
     * the invoking point (x0, y0) is less than the argument point (x1, y1) if and
     * only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that
     *            the other point
     * @return the value <tt>0</tt> if this point is equal to the argument point (x0
     *         = x1 and y0 = y1); a negative integer if this point is less than the
     *         argument point; and a positive integer if this point is greater than
     *         the argument point
     */
    @Override
    public int compareTo(Point o) {

        if (o == null) {
            throw new NullPointerException();
        }
        if (this.y < o.y || (this.y == o.y && this.x < o.x)) {
            return -1;
        } else if (this.y == o.y && this.x == o.x) {
            return 0;
        } else {
            return 1;
        }
    }

    private final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        public int compare(Point o1, Point o2) {
            double slope1 = slopeTo(o1);
            double slope2 = slopeTo(o2);
            if (slope1 == slope2) {
                return 0;
            }
            if (slope1 < slope2) {
                return -1;
            }
            return 1;
        }
    };

    public static void main(String[] args) {
        Point point = new Point(6, 4);
        System.out.println(point.slopeTo(new Point(9, 8)));

    }
}




