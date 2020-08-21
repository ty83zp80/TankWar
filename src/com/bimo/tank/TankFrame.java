package com.bimo.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
	/**
	 * Tank War V1.0
	 */
	private static final long serialVersionUID = 1L;
	public Tank tank = new Tank(200,400,50,50,Direction.UP,Group.GOOD,3,this);
	public List<Bullet> bList = new ArrayList<>();
	public List<Tank> enemyTanks = new ArrayList<>();
	
	public static final int GAME_WIDTH = 800, GAME_HEIGHT=600;
	public static final int STARTX = 100, STARTY = 100;
	
	public Explode exp  = new Explode(100,100,this);
	
	public TankFrame() {
		setResizable(false);
		setTitle("Tank War");
		setVisible(true);
		setBounds(STARTX, STARTY, GAME_WIDTH, GAME_HEIGHT);
		
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
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量是：" + bList.size(), 10, 50);
		g.drawString("敌方坦克的数量是：" + enemyTanks.size(), 10, 70);
		g.setColor(c);
		
		for(int i = 0 ; i<enemyTanks.size(); i++) {
			enemyTanks.get(i).paint(g);
		}
		
		tank.paint(g);
		
		exp.paint(g);
		for(int i = 0 ; i< bList.size(); i++) {
			bList.get(i).paint(g);
		}
		
		//敌方坦克碰撞检测
		for(int i = 0 ; i < bList.size();i++) {
			for(int j = 0 ;j < enemyTanks.size() ;j++) {
				bList.get(i).collideWidth(enemyTanks.get(j));
			}
		}
		//我方坦克碰撞检测
		//for(int i=0 ; i<bList.size(); i++) {
		//	bList.get(i).collideWidth(tank);
		//}
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
					tank.fire();
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
			}
			if(bR) {
				tank.setDir(Direction.RIGHT);
			}
			if(bU) {
				tank.setDir(Direction.UP);
			}
			if(bD) {
				tank.setDir(Direction.DOWN);
			}
			
		}
	}
	
}
