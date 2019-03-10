import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-10 05:20:44
 * @Description: TODO
 * @version V1.0
 */
public class PercolationStats {

    private double[] thresholdResults;
    private int trials;

    private static final double CONFIDENCE_95 = 1.96;

    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1) {
            throw new IllegalArgumentException("both arguments n and trials must be greater than 1");
        }

        this.trials = trials;
        thresholdResults = new double[trials];
        for (int t = 0; t < trials; t++) {
            Percolation percolation = new Percolation(n);
            int openSites = 0;
            while (!percolation.percolates()) {
                int i = StdRandom.uniform(1, n + 1);
                int j = StdRandom.uniform(1, n + 1);

                if (!percolation.isOpen(i, j)) {
                    percolation.open(i, j);
                    openSites += 1;
                }
            }
            double threshold = (double) openSites / (double) (n * n);
            thresholdResults[t] = threshold;
        }
    }

    public double mean() {
        return StdStats.mean(thresholdResults);
    }

    public double stddev() {
        return StdStats.stddev(thresholdResults);
    }

    public double confidenceLo() {
        return mean() - (CONFIDENCE_95 * stddev() / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + (CONFIDENCE_95 * stddev() / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        // int t = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(20, 10);
        StdOut.println("mean = " + stats.mean());
        StdOut.println("standard deviation = " + stats.stddev());
        StdOut.println("95% confidence interval = " + stats.confidenceLo() + " , " + stats.confidenceHi());
    }

}
