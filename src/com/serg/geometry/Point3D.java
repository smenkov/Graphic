package com.serg.geometry;

import java.awt.Graphics;
import com.serg.abstraction.Geometry3D;
import com.serg.abstraction.Object3D;

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
	public void draw(Graphics g) {

		// g.drawOval(x, y, 20, 20);
	}

}
