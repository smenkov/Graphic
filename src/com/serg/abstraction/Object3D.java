package com.serg.abstraction;

import java.util.ArrayList;

public abstract class Object3D implements Movable {

	private double x;
	private double y;
	private double z;

	private double rX;
	private double rY;
	private double rZ;

	private ArrayList<Geometry3D> geometry;

	private Object3D() {

	}

	public Object3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void move(double dx, double dy, double dz) {
		x += dx;
		y += dy;
		z += dz;
	}

	@Override
	public void rotate(double dx, double dy, double dz) {
		rX += dx;
		rY += dy;
		rZ += dz;
	}

	public void addGeometry(Geometry3D geometry) {
		this.geometry.add(geometry);
	}

}
