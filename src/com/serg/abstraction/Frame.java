package com.serg.abstraction;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public interface Frame {

	void draw(ArrayList<? extends Object3D> d);
	
	void addKeyListen(KeyListener kl);

	void close();

	void setInfoText(String format);
}
