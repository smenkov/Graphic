package com.serg.geometry;

import com.serg.abstraction.Object3D;

public class Flat extends Object3D {

	public Flat(double x, double y, double z) {
		super(x, y, z);

		addGeometry(new Point3D(1, 1, 1));

		// TODO Auto-generated constructor stub
	}

}
