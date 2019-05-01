package com.serg.serve;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import com.serg.Obj3D.Camera;
import com.serg.abstraction.Frame;
import com.serg.abstraction.Geometry3D;
import com.serg.abstraction.Object3D;

public class MainThread extends Thread implements KeyListener {

	private boolean isRunning;
	private long millis;
	private Frame mainFrame;
	private ArrayList<Object3D> materialObjects;
	private Camera camera;
	private double cameraVx;
	private double cameraVy;
	private double cameraVz;

	private double cameraAx;
	private double cameraAy;
	private double cameraAz;

	public MainThread(Frame mainFrame, ArrayList<Object3D> materialObjects) {
		super();
		this.camera = new Camera(0, 0, 0);
		this.mainFrame = mainFrame;
		this.materialObjects = materialObjects;
		this.mainFrame.addKeyListen(this);
	}

	@Override
	public void run() {
		super.run();
		isRunning = true;
		double t = 0; // second
		double z_dir = 0.1;
		while (isRunning && !isInterrupted()) {
			// TODO adding new materialObjects from buffer ->
			// millis = System.currentTimeMillis() % 1000;

			camera.move(cameraVx, cameraVy, cameraVz);
			camera.rotate(cameraAx, cameraAy, cameraAz);
			// camera.move(4*Math.sin(t), 0, 4*Math.cos(t));
			// camera.rotate(0, Math.PI / 400, 0);

			////////////// update objects ->
			mainFrame.setInfoText(
					String.format("X: %3.3f  Y: %3.3f  Z: %3.3f", camera.getX(), camera.getY(), camera.getZ()));

			for (Object3D s : materialObjects) {
				// update Object3D placement
				if (s.isMovable()) {
					if (s.getZ() > 200)
						z_dir = -0.1;
					else if (s.getZ() < -50)
						z_dir = 0.1;
					s.move(Math.cos(t) / 4, -Math.sin(t) / 6, z_dir);
					s.rotate(0, Math.PI / 200, 0); // 1pi rad/second (1000 millis)
				}
				// update geometry flat 2D coordinates
				for (Geometry3D geom : s.getGeometry()) {
					camera.update2DCoordinates(geom);
				}
			}

			// Draw objects ->
			mainFrame.draw(materialObjects);

			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO add correct ending
				e.printStackTrace();
			}
			t += 0.01;
			// System.out.println("Duration is: " + (System.currentTimeMillis() % 1000 -
			// millis));

		}

	}

	public void stop_() {
		setRunning(false);
		mainFrame.close();
		interrupt();
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public long getMillis() {
		return millis;
	}

	public void setMillis(long millis) {
		this.millis = millis;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			cameraVx = 0.1;
		} else if (key == KeyEvent.VK_D) {
			cameraVx = -0.1;
		}
		if (key == KeyEvent.VK_W) {
			cameraVy = 0.1;
		} else if (key == KeyEvent.VK_S) {
			cameraVy = -0.1;
		}
		if (key == KeyEvent.VK_E) {
			cameraVz = 0.1;
		} else if (key == KeyEvent.VK_Q) {
			cameraVz = -0.1;
		}
		if (key == KeyEvent.VK_LEFT) {
			cameraAy = -Math.PI / 200;
		} else if (key == KeyEvent.VK_RIGHT) {
			cameraAy = Math.PI / 200;
		}
		if (key == KeyEvent.VK_UP) {
			cameraAx = Math.PI / 200;
		} else if (key == KeyEvent.VK_DOWN) {
			cameraAx = -Math.PI / 200;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_D)
			cameraVx = 0;
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_S)
			cameraVy = 0;
		if (key == KeyEvent.VK_E || key == KeyEvent.VK_Q)
			cameraVz = 0;

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
			cameraAy = 0;
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)
			cameraAx = 0;
	}

	public Camera getCamera() {
		return camera;
	}

}
