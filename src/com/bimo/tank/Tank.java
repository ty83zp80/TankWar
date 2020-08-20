package com.bimo.tank;

import java.awt.Graphics;

public class Tank {
	
	private int x;
	private int y;
	private Direction dir;
	private int speed;
	private int width;
	private int height;
	
	private boolean moving = false;
	
	public Tank(int x, int y, int width, int height, Direction dir, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public void myPaint(Graphics g) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, width, height);
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
	
}