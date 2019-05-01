package com.serg.Obj3D;

import com.serg.abstraction.Geometry3D;
import com.serg.abstraction.Object3D;
import com.serg.geometry.Point3D;

public class Section extends Object3D {

	public Section(double x, double y, double z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub

	}

	public void setGeometry(Point3D a1, Point3D a2) {
		super.clearGeometry();
		super.addGeometry(a1);
		super.addGeometry(a2);
	}

	@Override
	public void addGeometry(Geometry3D geometry) {
		// TODO Auto-generated method stub
		System.out.print("Empty put");
	}

}
