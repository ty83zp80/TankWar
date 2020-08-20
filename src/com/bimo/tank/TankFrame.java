package com.bimo.tank;

import java.awt.Frame;
import java.awt.Graphics;
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
	
	public TankFrame() {
		setResizable(false);
		setTitle("Tank War");
		setVisible(true);
		setBounds(100, 100, 800, 600);
		
		this.addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void paint(Graphics g) {
		
		tank.myPaint(g);
		
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
			
			if(bL) tank.setDir(Direction.LEFT);
			if(bR) tank.setDir(Direction.RIGHT);
			if(bU) tank.setDir(Direction.UP);
			if(bD) tank.setDir(Direction.DOWN);
			
		}
	}
	
}
