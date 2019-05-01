package com.serg.Obj3D;

import com.serg.abstraction.Object3D;
import com.serg.geometry.Point3D;

public class Cube extends Object3D {

	public Cube(double x, double y, double z, double a, boolean movable) {
		super(x, y, z, movable);
		a = Math.abs(a);
		addGeometry(new Point3D(a / 2, a / 2, a / 2, this));
		addGeometry(new Point3D(a / 2, a / 2, -a / 2, this));
		addGeometry(new Point3D(a / 2, -a / 2, -a / 2, this));
		addGeometry(new Point3D(a / 2, -a / 2, a / 2, this));
		addGeometry(new Point3D(-a / 2, -a / 2, a / 2, this));
		addGeometry(new Point3D(-a / 2, a / 2, a / 2, this));
		addGeometry(new Point3D(-a / 2, a / 2, -a / 2, this));
		addGeometry(new Point3D(-a / 2, -a / 2, -a / 2, this));
	}

}
