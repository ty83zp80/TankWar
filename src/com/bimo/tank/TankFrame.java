package com.bimo.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	/**
	 * Tank War V1.0
	 */
	private static final long serialVersionUID = 1L;
	Tank tank = new Tank(200,200,50,50,Direction.DOWN,10);
	Bullet b = new Bullet(221,225,Direction.RIGHT);
	
	static final int GAME_WIDTH = 800, GAME_HEIGHT=600;
	
	public TankFrame() {
		setResizable(false);
		setTitle("Tank War");
		setVisible(true);
		setBounds(100, 100, GAME_WIDTH, GAME_HEIGHT);
		
		this.addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		
		tank.myPaint(g);
		b.paint(g);
	}
	
	
	class MyKeyListener extends KeyAdapter{
		
		boolean bU = false,bR= false, bD = false, bL = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
				case KeyEvent.VK_LEFT: 
					bL = true;
					break;
				case KeyEvent.VK_RIGHT:
					bR = true; 
					break;
				case KeyEvent.VK_UP:
					bU = true;
					break;
				case KeyEvent.VK_DOWN:
					bD = true;
					break;
				default:
					break;
			}
			setMainTankDirection();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
				case KeyEvent.VK_LEFT: 
					bL = false;
					break;
				case KeyEvent.VK_RIGHT:
					bR = false;
					
					break;
				case KeyEvent.VK_UP:
					bU = false;
					break;
				case KeyEvent.VK_DOWN:
					bD = false;
					break;
				default:
					break;
			}
			setMainTankDirection();
		}
		
		public void setMainTankDirection() {
			if(!bL && !bR && !bU && !bD) {
				tank.setMoving(false);
			}
			else {
				tank.setMoving(true);
			}
			
			if(bL){
				tank.setDir(Direction.LEFT);
				b.setDir(Direction.LEFT);
			}
			if(bR) {
				tank.setDir(Direction.RIGHT);
				b.setDir(Direction.RIGHT);
			}
			if(bU) {
				tank.setDir(Direction.UP);
				b.setDir(Direction.UP);
			}
			if(bD) {
				tank.setDir(Direction.DOWN);
				b.setDir(Direction.DOWN);
			}
			
		}
	}
	
}
