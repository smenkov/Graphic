package com.serg.geometry;

import java.awt.Graphics2D;

import com.serg.abstraction.Geometry3D;

public class Vector extends Geometry3D {

	public Vector(double x, double y, double z) {
		super(x, y, z, null);
	}

	public Vector(Point3D p1, Point3D p2) {
		super(p2.getLocal_x() - p1.getLocal_x(), p2.getLocal_y() - p1.getLocal_y(), p2.getLocal_z() - p1.getLocal_z(),
				null);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO no draw now

	}

	public static double getScalarMultiplication(Vector v1, Vector v2) {
		return v1.getLocal_x() * v2.getLocal_x() + v1.getLocal_y() * v2.getLocal_y()
				+ v1.getLocal_z() * v2.getLocal_z();
	}

	public double getLength() {
		return Math.sqrt(Math.pow(getLocal_x(), 2) + Math.pow(getLocal_y(), 2) + Math.pow(getLocal_z(), 2));
	}

	public Vector getKoleniar(double k) {
		return new Vector(k * getLocal_x(), k * getLocal_y(), k * getLocal_z());
	}

}
