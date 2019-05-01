package com.serg.serve;

import java.util.ArrayList;

import com.serg.Obj3D.Cube;
import com.serg.abstraction.Object3D;
import com.serg.visual.DrawFrame;

public class Starter {

	public static void main(String[] args) {
		// Create frame
		DrawFrame df = new DrawFrame("Test", 800, 600);
		ArrayList<Object3D> arr = new ArrayList<>();

		Cube cube1 = new Cube(0, 0, 20, 10, true);

		Cube cubeZ = new Cube(0, 0, 10, 1, false); // axis indicator ->
		Cube cubeX = new Cube(10, 0, 0, 1, false); //
		Cube cubeY = new Cube(0, 10, 0, 1, false); //

		arr.add(cube1);
		arr.add(cubeX);
		arr.add(cubeY);
		arr.add(cubeZ);

		// Start world thread
		MainThread mt = new MainThread(df, arr);
		mt.start();
		// temp///
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mt.stop_();
		//////////
	}

}
