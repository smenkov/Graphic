package com.serg.test;

import com.serg.Obj3D.Camera;
import com.serg.Obj3D.Section;
import com.serg.abstraction.Geometry3D;
import com.serg.geometry.Point3D;
import com.serg.geometry.Vector;

public class TestCamera {

	public static void main(String[] args) {
		// Bad Object3D example. It contain 2 Point3D //
		Section section = new Section(0, 0, 9);
		section.setGeometry(new Point3D(0, 1, 0, section), new Point3D(0, 0, 0, section));
		// Create camera in the world //
		Camera camera = new Camera(0, 0, 0);

		Vector projection;
		camera.rotate(25, 0, 0);

		// Calculate 2D projection from Section`s 3D geometry ->

		for (Geometry3D g : section.getGeometry()) {
			if (camera.canSee(g)) {
				projection = camera.getVectorProjection(g);
				System.out.printf("X2d = %4.2f X3d = %4.2f\n", projection.getLocal_x(),
						g.getLocal_x() + section.getX());
				System.out.printf("Y2d = %4.2f Y3d = %4.2f\n", projection.getLocal_y(),
						g.getLocal_y() + section.getY());
				System.out.printf("Z2d = %4.2f Z3d = %4.2f\n", projection.getLocal_z(),
						g.getLocal_z() + section.getZ());
				System.out.println();
			} else
				System.out.println("Can`t see this object");
		}

	}

}
