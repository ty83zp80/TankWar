package com.bimo.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	
	private int x;
	private int y;
	private Direction dir;
	private int speed;
	private int width;
	private int height;
	private TankFrame f;
	
	private boolean moving = false;
	public Tank(int x, int y, int width, int height, Direction dir, int speed, TankFrame f) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.speed = speed;
		this.width = width;
		this.height = height;
		this.f = f;
	}
	
	public void myPaint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		g.setColor(c);
		move();
	}
	
	private void move() {
		// TODO Auto-generated method stub
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
		f.bList.add(new Bullet(this.x, this.y,this.dir));
	}
}
