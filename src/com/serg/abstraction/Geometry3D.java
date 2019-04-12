package com.serg.abstraction;

import java.util.ArrayList;

public abstract class Geometry3D implements Drawable, Movable {

	private double x_l;
	private double y_l;
	private double z_l;

	private ArrayList<Geometry3D> linked;

	public Geometry3D(double x_l, double y_l, double z_l) {
		this.x_l = x_l;
		this.y_l = y_l;
		this.z_l = z_l;
	}

	@Override
	public void move(double dx, double dy, double dz) {
		x_l += dx;
		y_l += dy;
		z_l += dz;

	}

	@Override
	public void rotate(double dx, double dy, double dz) {
		// x-axis
		y_l = y_l * Math.cos(dx) - z_l * Math.sin(dx);
		z_l = y_l * Math.sin(dx) + z_l * Math.cos(dx);
		// y-axis
		x_l = x_l * Math.cos(dy) + z_l * Math.sin(dy);
		z_l = y_l * Math.cos(dy) - x_l * Math.sin(dy);
		// z-axis
		x_l = x_l * Math.cos(dz) - y_l * Math.sin(dy);
		y_l = x_l * Math.sin(dz) + y_l * Math.cos(dy);
	}

	public double getX_l() {
		return x_l;
	}

	public void setX_l(double x_l) {
		this.x_l = x_l;
	}

	public double getY_l() {
		return y_l;
	}

	public void setY_l(double y_l) {
		this.y_l = y_l;
	}

	public double getZ_l() {
		return z_l;
	}

	public void setZ_l(double z_l) {
		this.z_l = z_l;
	}

	public ArrayList<Geometry3D> getLinked() {
		return linked;
	}

	public void setLinked(ArrayList<Geometry3D> linked) {
		this.linked = linked;
	}

}
