package com.serg.serve;

import java.util.ArrayList;

import com.serg.abstraction.Object3D;
import com.serg.visual.DrawFrame;

public class Starter {

	public static void main(String[] args) {
		DrawFrame df = new DrawFrame("Test", 600, 400);
		ArrayList<Object3D> arr = new ArrayList<>();
		// arr.add(new Dot());
		// arr.add(new Dot(100, 100, 100, Color.CYAN));
		MainThread mt = new MainThread(df, arr);
		mt.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mt.stop_();
	}

}
