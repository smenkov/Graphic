package com.serg.visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.serg.abstraction.Drawable;
import com.serg.abstraction.Frame;
import com.serg.abstraction.Object3D;

public class DrawFrame extends JFrame implements Frame {

	/**
	 * 
	 */
	public static int WIDTH;
	public static int HEIGHT;
	private static final long serialVersionUID = 1L;
	private String message = null;

	private ArrayList<? extends Object3D> dBuff;

	public DrawFrame(String title, int width, int height) throws HeadlessException {
		super(title);
		WIDTH = width;
		HEIGHT = height;
		setSize(width, height);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new MainPanel());
		setVisible(true);
	}

	class MainPanel extends JPanel implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			doDrawing(g);
		}

		private void doDrawing(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;

			g2d.setColor(Color.white);
			g2d.fillRect(0, 0, DrawFrame.WIDTH, DrawFrame.HEIGHT);
			if (message != null) {
				g2d.setColor(Color.black);
				g2d.drawString(message, 10, 12);
				message = null;
			}

			if (dBuff != null)
				for (Object3D od : dBuff)
					for (Drawable d : od.getGeometry())
						d.draw(g2d);

			Toolkit.getDefaultToolkit().sync();
			g2d.dispose();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	@Override
	public void draw(ArrayList<? extends Object3D> d) {
		dBuff = d;
		repaint();
	}

	@Override
	public void close() {
		dispose();
	}

	@Override
	public void addKeyListen(KeyListener kl) {
		addKeyListener(kl);
	}

	@Override
	public void setInfoText(String info) {
		message = info;
	}

}
