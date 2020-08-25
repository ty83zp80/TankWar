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
	
	Rectangle rectBullet = new Rectangle();
	public Bullet(int x, int y, Direction dir,Group group,TankFrame f) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.f = f;
		
		rectBullet.x = x;
		rectBullet.y = y;
		rectBullet.width = WIDTH;
		rectBullet.height = HEIGHT;
		
		f.bList.add(this);
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
		rectBullet.x = x;
		rectBullet.y = y;
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
		Rectangle rectTank = tank.getRectTank();
		if(rectBullet.intersects(rectTank)) {
			tank.die();
			this.die();
			int eX = tank.getX() + tank.getWidth() / 2 - Explode.WIDTH / 2;
			int eY = tank.getY() + tank.getHeight() / 2 - Explode.HEIGHT / 2;
			f.exp.add(new Explode(eX,eY,f));
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
