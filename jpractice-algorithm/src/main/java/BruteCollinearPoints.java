import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-28 16:40:40
 * @Description: TODO
 * @version V1.0
 */
public class BruteCollinearPoints {

    private LineSegment[] segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {

        checkDuplicatedEntries(points);

        ArrayList<LineSegment> lineSegments = new ArrayList<>();
        
        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        Arrays.sort(pointsCopy);
        
        for (int i = 0; i < points.length - 3; i++) {
            for (int p = i + 1; p < points.length - 2; p++) {
                for (int q = p + 1; q < points.length - 1; q++) {
                    for (int r = q + 1; r < points.length; r++) {
                        if (pointsCopy[i].slopeTo(pointsCopy[p]) == pointsCopy[i].slopeTo(pointsCopy[q])
                                && pointsCopy[i].slopeTo(pointsCopy[p]) == pointsCopy[i].slopeTo(pointsCopy[r])) {
                            lineSegments.add(new LineSegment(pointsCopy[i], pointsCopy[r]));
                        }
                    }
                }
            }
        }
        
        segments = lineSegments.toArray(new LineSegment[lineSegments.size()]);

    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return Arrays.copyOf(segments, numberOfSegments());
    }

    private void checkDuplicatedEntries(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicated entries in given points.");
                }
            }
        }
    }
    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
