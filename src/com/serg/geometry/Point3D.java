package com.serg.geometry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import com.serg.abstraction.Geometry3D;
import com.serg.abstraction.Object3D;
import com.serg.visual.DrawFrame;

public class Point3D extends Geometry3D {

	public Point3D(double x_l, double y_l, double z_l, Object3D parent) {
		super(x_l, y_l, z_l, parent);
		// TODO Auto-generated constructor stub
	}

	public Point3D(Geometry3D g, Object3D parent) {

		super(g.getLocal_x(), g.getLocal_y(), g.getLocal_z(), parent);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.black);
		Ellipse2D.Double shape = new Ellipse2D.Double(-getX_2D() + DrawFrame.WIDTH / 2,
				-getY_2D() + DrawFrame.HEIGHT / 2, 10, 10);
		g2d.draw(shape);
	}

}
