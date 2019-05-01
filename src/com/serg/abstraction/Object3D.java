package com.serg.abstraction;

import java.util.ArrayList;

public abstract class Object3D implements Movable {

	private boolean movable = true;

	private double x;
	private double y;
	private double z;

	private double angle_x;
	private double angle_y;
	private double angle_z;

	private ArrayList<Geometry3D> geometry = new ArrayList<>();

	public Object3D(double x, double y, double z, boolean movable) {
		this.movable = movable;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void move(double dx, double dy, double dz) {
		if (movable) {
			x += dx;
			y += dy;
			z += dz;
		}
	}

	public void rotate(double angle_x, double angle_y, double angle_z) {
		if (movable) {
			this.angle_x = angle_x;
			this.angle_y = angle_y;
			this.angle_z = angle_z;

			// rotate all geometry around local axis
			for (Geometry3D g : geometry)
				g.rotate(this.angle_x, this.angle_y, this.angle_z);
		}
	}

	protected void addGeometry(Geometry3D geometry) {
		this.geometry.add(geometry);
	}

	protected void clearGeometry() {
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

	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}
	
	
	
	
}
