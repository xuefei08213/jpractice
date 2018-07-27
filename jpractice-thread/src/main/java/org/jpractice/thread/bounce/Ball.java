/**
 * 
 */
package org.jpractice.thread.bounce;

import java.awt.geom.Rectangle2D;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-03 07:24:04
 * @Description: TODO
 * @version V1.0
 */
public class Ball {

	private static final int XSIZE = 15;

	private static final int YSIZE = 15;

	private double x = 0;

	private double y = 0;

	private double dx = 1;

	private double dy = 1;

	public void move(Rectangle2D bounds) {
		x += dx;
		y += dy;

		if (x < bounds.getMinX()) {
			x = bounds.getMinX();
			dx = -dx;
		}

		if (x + XSIZE > bounds.getMaxX()) {
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}

	}
}