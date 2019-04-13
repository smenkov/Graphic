package com.serg.visual;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.serg.abstraction.Drawable;
import com.serg.abstraction.Frame;
import com.serg.abstraction.Object3D;

public class DrawFrame extends JFrame implements Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<? extends Object3D> dBuff;
	private Canvas customCanvas;

	public DrawFrame(String title, int width, int height) throws HeadlessException {
		super(title);
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		customCanvas = new Canvas() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private Image dbImage;
			private Graphics dbg;

			public void update(Graphics g) {
				// initialize buffer
				if (dbImage == null) {

					dbImage = createImage(this.getSize().width, this.getSize().height);
					dbg = dbImage.getGraphics();

				}
				// clear screen in background
				dbg.setColor(getBackground());
				dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
				// draw elements in background
				dbg.setColor(getForeground());
				paint(dbg);
				// draw image on the screen
				g.drawImage(dbImage, 0, 0, this);
			}

			public void paint(Graphics g) {
				if (dBuff != null)
					for (Object3D od : dBuff)
						for (Drawable d : od.getGeometry())
							d.draw(g);
			}
		};
		add(customCanvas);
		setVisible(true);
	}

	@Override
	public void draw(ArrayList<? extends Object3D> d) {
		dBuff = d;
		customCanvas.repaint();
	}

	@Override
	public void close() {
		dispose();
	}

}
