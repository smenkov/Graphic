package com.serg.Obj3D;

import com.serg.abstraction.Geometry3D;
import com.serg.abstraction.Object3D;
import com.serg.geometry.Vector;

public class Camera extends Object3D {

	private Vector vN;
	private Vector vX;
	private Vector vY;
	private double d = 5.0;

	public Camera(double x, double y, double z) {
		super(x, y, z);
		// X Y Z - camera focus coordinates

		// vX - The final X axis
		vX = new Vector(1, 0, 0);
		// vY - The final Y axis
		vY = new Vector(0, 1, 0);
		// vN - Normal vector of the projection plane
		vN = new Vector(0, 0, 1);
		// add geometry to storage for rotate and move ability
		addGeometry(vX);
		addGeometry(vY);
		addGeometry(vN);
	}

	public boolean canSee(Geometry3D geom) {
		// c_d - distance component for global plane
		double c_d = vN.getLocal_x() * getX() + vN.getLocal_y() * getY() + vN.getLocal_z() * getZ();
		// @pos - distance @geom relative plane vN.x * x + vN.y * y + vN.z * z = d + c_d
		// //
		double pos = vN.getX() * geom.getX() + vN.getY() * geom.getY() + vN.getZ() * geom.getZ() - d - c_d;
		// pos >= 0 then camera direct on the object
		if (pos >= 0) {
			Vector vP = new Vector(geom.getX(), geom.getY(), geom.getZ());
			// calculate arcCos from scalar vector multiplication
			double degrees = Math
					.toDegrees(Math.acos(Vector.getScalarMultiplication(vP, vN) / (vP.getLength() * vN.getLength())));
			// camera angel of view is 120 degrees < -60 |0| 60 >
			return degrees <= 60 ? true : degrees >= 120 ? true : false;
		}
		return false;
	}

	public Vector getVectorProjection(Geometry3D geom) {
		// crate vector to @geom from 0,0,0 xyz
		Vector vP = new Vector(geom.getX(), geom.getY(), geom.getZ());

		// check vP visible
		if (canSee(vP)) {

			double c_d = vN.getLocal_x() * getX() + vN.getLocal_y() * getY() + vN.getLocal_z() * getZ();
			// Vector from camera focus to point geom
			Vector c_vp = new Vector(vP.getX() - getX(), vP.getY() - getY(), vP.getZ() - getZ());
			double vp$n = Vector.getScalarMultiplication(vP, vN);
			double c_vp$n = Vector.getScalarMultiplication(c_vp, vN);
			// result - point x y z which belongs the projection plane
			Vector result = new Vector(vP.getX() - c_vp.getX() * (vp$n - d - c_d) / c_vp$n,
					vP.getY() - c_vp.getY() * (vp$n - d - c_d) / c_vp$n,
					vP.getZ() - c_vp.getZ() * (vp$n - d - c_d) / c_vp$n);
			// calculate x y 2D relative the center [A] of projection plane //
			Vector vAP = new Vector(result.getX() - vN.getX() * d, result.getY() - vN.getY() * d,
					result.getZ() - vN.getZ() * d);
			double x = vAP.getX() * (vY.getY() * vN.getZ() - vY.getZ() * vN.getY())
					- vY.getX() * (vAP.getY() * vN.getZ() - vAP.getZ() * vN.getY())
					+ vN.getX() * (vAP.getY() * vY.getZ() - vAP.getZ() * vY.getY());

			double y = vX.getX() * (vAP.getY() * vN.getZ() - vAP.getZ() * vN.getY())
					- vAP.getX() * (vX.getY() * vN.getZ() - vX.getZ() * vN.getY())
					+ vN.getX() * (vX.getY() * vAP.getZ() - vX.getZ() * vAP.getY());

			// z always equals 0 because vector AP belong the XaY plane
			double z = vX.getX() * (vY.getY() * vAP.getZ() - vY.getZ() * vAP.getY())
					- vY.getX() * (vX.getY() * vAP.getZ() - vX.getZ() * vAP.getY())
					+ vAP.getX() * (vX.getY() * vY.getZ() - vX.getZ() * vY.getY());

			return new Vector(x, y, z);

		} else {
			System.out.println("Can`t see this object!");
			return null;
		}
	}

	public Vector getDirection() {
		return vN;
	}
}
