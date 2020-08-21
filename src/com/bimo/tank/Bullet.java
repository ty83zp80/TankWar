package com.bimo.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private static final int SPEED = 10;
	public static final int WIDTH = ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
	private int x,y ;
	private Direction dir;
	private boolean alive = true;
	private TankFrame f;
	private Group group;
	public Bullet(int x, int y, Direction dir,Group group,TankFrame f) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.f = f;
	}
	
	public void paint(Graphics g) {
		if(!alive) {
			f.bList.remove(this);
		}
		switch(dir) {
			case LEFT: g.drawImage(ResourceMgr.bulletL, x, y, null);break;
			case RIGHT: g.drawImage(ResourceMgr.bulletR, x, y, null);break;
			case DOWN: g.drawImage(ResourceMgr.bulletD, x, y, null);break;
			case UP: g.drawImage(ResourceMgr.bulletU, x, y, null);break;
			default : break;
		}
		move();
	}
	
	public void move() {
		switch(dir) {
			case LEFT: 
				x-=SPEED;
				break;
			case RIGHT: 
				x += SPEED; 
				break;
			case UP: 
				y -=SPEED ;
				break;
			case DOWN: 
				y += SPEED; 
				break;
			default : break;
		}
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH  || y> TankFrame.GAME_HEIGHT) {
			alive = false;
		}
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	public void collideWidth(Tank tank) {
		if(this.group == tank.getGroup()) return;
		//TODO: 需要创建一个公用的Rectangle，来分别装在
		Rectangle rectBullet = new Rectangle(this.x, this.y, WIDTH,HEIGHT);
		Rectangle rectTank = new Rectangle(tank.getX(),tank.getY(),tank.getWidth(),tank.getHeight());
		if(rectBullet.intersects(rectTank)) {
			tank.die();
			this.die();
		}
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	private void die() {
		// TODO Auto-generated method stub
		this.alive = false;
	}
	
	
}
