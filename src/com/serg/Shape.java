package com.serg;

import java.awt.Color;

public abstract class Shape extends MaterialObject {

	private double x;
	private double y;
	private double z;
	
	private Color c = Color.black;
	
	
	
	public Shape() {
		
	}

	public Shape(double x, double y, double z, Color c) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.c = c;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}
