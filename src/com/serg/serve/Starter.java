package com.serg.serve;

import java.util.ArrayList;

import com.serg.abstraction.Object3D;
import com.serg.visual.DrawFrame;

public class Starter {

	public static void main(String[] args) {
		// Create frame
		DrawFrame df = new DrawFrame("Test", 600, 400);
		ArrayList<Object3D> arr = new ArrayList<>();
		// Start world thread
		MainThread mt = new MainThread(df, arr);
		mt.start();
		// temp///
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mt.stop_();
		//////////
	}

}
