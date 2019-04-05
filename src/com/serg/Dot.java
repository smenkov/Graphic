package com.serg;

import java.awt.Color;
import java.awt.Graphics;

public class Dot extends Shape {

	public Dot() {
	}

	public Dot(double x, double y, double z, Color c) {
		super(x, y, z, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getC());
		g.fillRect((int) getX(), (int) getY(), 20, 20);
	}

	@Override
	public void move(double dx, double dy, double dz) {
		setX(getX() + dx);
		setY(getY() + dy);
		setZ(getZ() + dz);
	}

}
