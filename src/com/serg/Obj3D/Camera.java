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
		double pos = vN.getGlobal_x() * geom.getGlobal_x() + vN.getGlobal_y() * geom.getGlobal_y()
				+ vN.getGlobal_z() * geom.getGlobal_z() - d - c_d;
		// pos >= 0 then camera direct on the object
		if (pos >= 0) {
			Vector vP = new Vector(geom.getGlobal_x(), geom.getGlobal_y(), geom.getGlobal_z());
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
		Vector vP = new Vector(geom.getGlobal_x(), geom.getGlobal_y(), geom.getGlobal_z());

		// check vP visible
		if (canSee(vP)) {

			double c_d = vN.getLocal_x() * getX() + vN.getLocal_y() * getY() + vN.getLocal_z() * getZ();
			// Vector from camera focus to point geom
			Vector c_vp = new Vector(vP.getGlobal_x() - getX(), vP.getGlobal_y() - getY(), vP.getGlobal_z() - getZ());
			double vp$n = Vector.getScalarMultiplication(vP, vN);
			double c_vp$n = Vector.getScalarMultiplication(c_vp, vN);
			// result - point x y z which belongs the projection plane
			Vector result = new Vector(vP.getGlobal_x() - c_vp.getGlobal_x() * (vp$n - d - c_d) / c_vp$n,
					vP.getGlobal_y() - c_vp.getGlobal_y() * (vp$n - d - c_d) / c_vp$n,
					vP.getGlobal_z() - c_vp.getGlobal_z() * (vp$n - d - c_d) / c_vp$n);
			// calculate x y 2D relative the center [A] of projection plane //
			Vector vAP = new Vector(result.getGlobal_x() - vN.getGlobal_x() * d,
					result.getGlobal_y() - vN.getGlobal_y() * d, result.getGlobal_z() - vN.getGlobal_z() * d);
			double x = vAP.getGlobal_x() * (vY.getGlobal_y() * vN.getGlobal_z() - vY.getGlobal_z() * vN.getGlobal_y())
					- vY.getGlobal_x() * (vAP.getGlobal_y() * vN.getGlobal_z() - vAP.getGlobal_z() * vN.getGlobal_y())
					+ vN.getGlobal_x() * (vAP.getGlobal_y() * vY.getGlobal_z() - vAP.getGlobal_z() * vY.getGlobal_y());

			double y = vX.getGlobal_x() * (vAP.getGlobal_y() * vN.getGlobal_z() - vAP.getGlobal_z() * vN.getGlobal_y())
					- vAP.getGlobal_x() * (vX.getGlobal_y() * vN.getGlobal_z() - vX.getGlobal_z() * vN.getGlobal_y())
					+ vN.getGlobal_x() * (vX.getGlobal_y() * vAP.getGlobal_z() - vX.getGlobal_z() * vAP.getGlobal_y());

			// z always equals 0 because vector AP belong the XaY plane
			double z = vX.getGlobal_x() * (vY.getGlobal_y() * vAP.getGlobal_z() - vY.getGlobal_z() * vAP.getGlobal_y())
					- vY.getGlobal_x() * (vX.getGlobal_y() * vAP.getGlobal_z() - vX.getGlobal_z() * vAP.getGlobal_y())
					+ vAP.getGlobal_x() * (vX.getGlobal_y() * vY.getGlobal_z() - vX.getGlobal_z() * vY.getGlobal_y());

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
