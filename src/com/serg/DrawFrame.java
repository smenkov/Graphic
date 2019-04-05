package com.serg;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFrame extends JFrame implements Frame {

	private JPanel panel;
	private ArrayList<? extends MaterialObject> dBuff;

	private DrawFrame() {
	}

	public DrawFrame(String title, int width, int height) throws HeadlessException {
		super(title);
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (dBuff != null)
					for (Drawable d : dBuff)
						d.draw(g);
			}

		};

		add(panel);
		setVisible(true);
	}

	@Override
	public void draw(ArrayList<? extends MaterialObject> d) {
		dBuff = d;
		panel.repaint();
	}

	@Override
	public void close() {
		panel.setVisible(false);
		dispose();
	}

}
