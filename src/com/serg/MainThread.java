package com.serg;

import java.util.ArrayList;

public class MainThread extends Thread {

	private boolean isRunning;
	private long millis;
	private Frame mainFrame;
	private ArrayList<Shape> shapes;

	public MainThread(Frame mainFrame, ArrayList<Shape> shapes) {
		super();
		this.mainFrame = mainFrame;
		this.shapes = shapes;

	}

	@Override
	public void run() {
		super.run();
		isRunning = true;
		while (isRunning && !isInterrupted()) {
			for (Shape s : shapes) {
				s.move(0.5, 1, 0);
			}
			mainFrame.draw(shapes);
			
			try {
				sleep(19);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
