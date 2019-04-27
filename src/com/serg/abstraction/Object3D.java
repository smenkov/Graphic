package com.serg.abstraction;

import java.util.ArrayList;

import com.serg.geometry.Point3D;

public abstract class Object3D implements Movable {

	private double x;
	private double y;
	private double z;

	private double angle_x;
	private double angle_y;
	private double angle_z;

	private ArrayList<Geometry3D> geometry;

	@SuppressWarnings("unused")
	private Object3D() {

	}

	public Object3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		geometry = new ArrayList<>();
	}

	@Override
	public void move(double dx, double dy, double dz) {
		x += dx;
		y += dy;
		z += dz;
	}

	public void rotate(double angle_x, double angle_y, double angle_z) {
		this.angle_x += angle_x;
		this.angle_y += angle_y;
		this.angle_z += angle_z;
		for (Geometry3D g : geometry)
			g.rotate(this.angle_x, this.angle_y, this.angle_z);
	}

	public void addGeometry(Geometry3D geometry) {
		this.geometry.add(geometry);
	}

	public void clearGeometry() {
		geometry = new ArrayList<Geometry3D>();
	}

	public ArrayList<Geometry3D> getGeometry() {
		// TODO Auto-generated method stub
		return geometry;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public Point3D getGlobalPoint() {
		return new Point3D(x, y, z, null);
	}

}
