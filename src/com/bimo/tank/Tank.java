package com.bimo.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tank {
	
	private int x;
	private int y;
	private Direction dir;
	private int speed;
	private int width;
	private int height;
	private TankFrame f;
	
	private boolean moving = true;
	private boolean alive = true;
	private Group group;
	
	private Random random = new Random();
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Tank(int x, int y, int width, int height, Direction dir,Group group, int speed, TankFrame f) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.speed = speed;
		this.width = width;
		this.height = height;
		this.f = f;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void paint(Graphics g) {
		if(!alive && group == Group.BAD) f.enemyTanks.remove(this);
		
		switch(dir) {
			case LEFT: g.drawImage(ResourceMgr.tankL, x, y, null);break;
			case RIGHT: g.drawImage(ResourceMgr.tankR, x, y, null);break;
			case DOWN: g.drawImage(ResourceMgr.tankD, x, y, null);break;
			case UP: g.drawImage(ResourceMgr.tankU, x, y, null);break;
			default : break;
		}
		move();
	}
	
	private void move() {
		if(!moving) return;
		switch(dir) {
			case LEFT: 
				x-=speed;
				break;
			case RIGHT: 
				x += speed; 
				break;
			case UP: 
				y -=speed ;
				break;
			case DOWN: 
				y += speed; 
				break;
			default : break;
		}
		if(random.nextInt(10)>8 && group == Group.BAD) fire();
	}
	
	public Direction getDir() {
		return dir;
	}
	
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	public void setMoving(boolean b) {
		// TODO Auto-generated method stub
		this.moving = b;
	}
	
	public void fire() {
		int startX = x, startY = y;
		switch(dir){
			case LEFT: 
				startY = y + height / 2 - Bullet.HEIGHT/2;
				break;
			case RIGHT: 
				startX = x + width;
				startY = y + height / 2 - Bullet.HEIGHT/2;
				break;
			case UP: 
				startX = x + width / 2 - Bullet.WIDTH/2;
				break;
			case DOWN: 
				startX = x + width / 2 -  Bullet.WIDTH/2;
				startY = y + height;
				break;
			default:break;
			
		}
		f.bList.add(new Bullet(startX, startY,this.dir,this.group,this.f));
	}

	public void die() {
		// TODO Auto-generated method stub
		this.alive  = false;
	}
}
