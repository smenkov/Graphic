package com.serg;

import java.util.ArrayList;

public interface Frame {

	void draw(ArrayList<? extends MaterialObject> d);

	void close();
}
