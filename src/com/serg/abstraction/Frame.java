package com.serg.abstraction;

import java.util.ArrayList;

public interface Frame {

	void draw(ArrayList<? extends Object3D> d);

	void close();
}
