package com.serg.serve;

import java.util.ArrayList;

import com.serg.abstraction.Frame;
import com.serg.abstraction.Object3D;

public class MainThread extends Thread {

	private boolean isRunning;
	private long millis;
	private Frame mainFrame;
	private ArrayList<Object3D> materialObjects;

	public MainThread(Frame mainFrame, ArrayList<Object3D> materialObjects) {
		super();
		this.mainFrame = mainFrame;
		this.materialObjects = materialObjects;

	}

	@Override
	public void run() {
		super.run();
		isRunning = true;
		while (isRunning && !isInterrupted()) {
			// TODO adding new materialObjects from buffer ->

			//////////////
			// Draw objects ->
			for (Object3D s : materialObjects) {
				s.move(0.5, 1, 0);
			}
			mainFrame.draw(materialObjects);

			try {
				sleep(30);
			} catch (InterruptedException e) {
				// TODO add correct ending
				e.printStackTrace();
			}
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

}
