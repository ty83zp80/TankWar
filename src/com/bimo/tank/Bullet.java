package com.bimo.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static final int SPEED = 10;
	private static final int WIDTH = 8, HEIGHT = 8;
	private int x,y ;
	private Direction dir;
	
	
	public Bullet(int x, int y, Direction dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
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
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
}