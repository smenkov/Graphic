package com.serg.abstraction;

import java.util.ArrayList;

public abstract class Geometry3D implements Drawable, Movable {

	private double local_x;
	private double local_y;
	private double local_z;
	private double x_2D;
	private double y_2D;
	
	private Object3D parent;

	private ArrayList<Geometry3D> linked;

	public Geometry3D(double local_x, double local_y, double local_z, Object3D parent) {
		this.local_x = local_x;
		this.local_y = local_y;
		this.local_z = local_z;
		this.parent = parent;
	}

	@Override
	public void move(double dx, double dy, double dz) {
		local_x += dx;
		local_y += dy;
		local_z += dz;

	}

	public void rotate(double angle_x, double angle_y, double angle_z) {
		//angle_x = Math.toRadians(angle_x);
		//angle_y = Math.toRadians(angle_y);
		//angle_z = Math.toRadians(angle_z);
		double old_x = local_x;
		double old_y = local_y;
		double old_z = local_z;

		// the rotate matrix -> doing successively

		// x-axis
		local_y = old_y * Math.cos(angle_x) - old_z * Math.sin(angle_x);
		local_z = old_y * Math.sin(angle_x) + old_z * Math.cos(angle_x);
		// y-axis
		old_x = local_x;
		old_y = local_y;
		old_z = local_z;
		local_x = old_x * Math.cos(angle_y) + old_z * Math.sin(angle_y);
		local_z = old_z * Math.cos(angle_y) - old_x * Math.sin(angle_y);
		// z-axis
		old_x = local_x;
		old_y = local_y;
		old_z = local_z;
		local_x = old_x * Math.cos(angle_z) - old_y * Math.sin(angle_z);
		local_y = old_x * Math.sin(angle_z) + old_y * Math.cos(angle_z);
	}

	public double getLocal_x() {
		return local_x;
	}

	public void setLocal_x(double local_x) {
		this.local_x = local_x;
	}

	public double getLocal_y() {
		return local_y;
	}

	public void setLocal_y(double local_y) {
		this.local_y = local_y;
	}

	public double getLocal_z() {
		return local_z;
	}

	public void setLocal_z(double local_z) {
		this.local_z = local_z;
	}

	public ArrayList<Geometry3D> getLinked() {
		return linked;
	}

	public void setLinked(ArrayList<Geometry3D> linked) {
		this.linked = linked;
	}

	public double getX() {
		return parent != null ? parent.getX() + local_x : local_x;
	}

	public double getY() {
		return parent != null ? parent.getY() + local_y : local_y;
	}

	public double getZ() {
		return parent != null ? parent.getZ() + local_z : local_z;
	}

	public Object3D getParent() {
		return parent;
	}

	public double getX_2D() {
		return x_2D;
	}

	public void setX_2D(double x_2d) {
		x_2D = x_2d;
	}

	public double getY_2D() {
		return y_2D;
	}

	public void setY_2D(double y_2d) {
		y_2D = y_2d;
	}

	
	
	
}
