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
	
	public static final int GAME_WIDTH = 800, GAME_HEIGHT=600;
	public static final int STARTX = 100, STARTY = 100;
	
	GameModel gm = new GameModel();	
	public TankFrame() {
		//setBounds(STARTX, STARTY, GAME_WIDTH, GAME_HEIGHT);
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setResizable(false);
		setTitle("Tank War");
		setVisible(true);
		
		
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
		gm.paint(g);
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
				case KeyEvent.VK_SPACE:
					gm.getMainTank().fire();
					break;
				default:
					break;
			}
			setMainTankDirection();
		}
		
		public void setMainTankDirection() {
			if(!bL && !bR && !bU && !bD) {
				gm.getMainTank().setMoving(false);
			}
			else {
				gm.getMainTank().setMoving(true);
			}
			
			if(bL){
				gm.getMainTank().setDir(Direction.LEFT);
			}
			if(bR) {
				gm.getMainTank().setDir(Direction.RIGHT);
			}
			if(bU) {
				gm.getMainTank().setDir(Direction.UP);
			}
			if(bD) {
				gm.getMainTank().setDir(Direction.DOWN);
			}
			
		}
	}
	
}
