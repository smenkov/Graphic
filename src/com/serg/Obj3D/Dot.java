package com.serg;

import java.awt.Color;
import java.awt.Graphics;

import com.serg.abstraction.Object3D;

public class Dot extends Object3D {

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
