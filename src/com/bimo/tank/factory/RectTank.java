package com.bimo.tank.factory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.bimo.tank.DefaultFireStrategy;
import com.bimo.tank.Direction;
import com.bimo.tank.FireStrategy;
import com.bimo.tank.FourBulletsFireStrategy;
import com.bimo.tank.GameModel;
import com.bimo.tank.Group;
import com.bimo.tank.ResourceMgr;
import com.bimo.tank.TankFrame;
import com.bimo.tank.factory.BaseTank;

public class RectTank extends BaseTank {
	
	private int x;
	private int y;
	private Direction dir;
	private int speed;
	private int width;
	private int height;
	
	private boolean moving = true;
	private boolean alive = true;
	private Group group;
	
	private Random random = new Random();
	private FireStrategy fs;
	
	public Rectangle getRectTank() {
		return rectTank;
	}

	public void setRectTank(Rectangle rectTank) {
		this.rectTank = rectTank;
	}

	private Rectangle rectTank = new Rectangle();
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public RectTank(int x, int y, int width, int height, Direction dir,Group group, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.speed = speed;
		this.width = width;
		this.height = height;
		
		rectTank.x = x;
		rectTank.y = y;
		rectTank.width = width;
		rectTank.height = height;
		
		if(group == Group.GOOD) {
			fs = FourBulletsFireStrategy.INSTANCE;
		}else {
			fs = DefaultFireStrategy.INSTANCE;
		}
		GameModel.getInstance().add(this);
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
	@Override
	public void paint(Graphics g) {
		if(!alive && group == Group.BAD) GameModel.getInstance().remove(this);
		
		Color c = g.getColor();
		g.setColor(group == Group.GOOD ? Color.RED : Color.BLUE);
		g.fillRect(x, y, 40, 40);
		g.setColor(c);
		move();
	}
	
	private void move() {
		if(!moving) return;
		switch(dir) {
			case LEFT: 
				x-=speed;
				boundsCheck();
				break;
			case RIGHT: 
				x += speed; 
				boundsCheck();
				break;
			case UP: 
				y -=speed ;
				boundsCheck();
				break;
			case DOWN: 
				y += speed; 
				boundsCheck();
				break;
			default : break;
		}
		
		rectTank.x = x;
		rectTank.y = y;
		if(this.group == Group.BAD && random.nextInt(10)>8 && group == Group.BAD) fs.fire(this);
		if(this.group == Group.BAD && random.nextInt(100)>95)
			randomDirection();
	}
	
	private void boundsCheck() {
		if(this.x < this.width / 2) x = this.width/2;
		if(this.y < this.height / 2) 	y = this.height / 2;
		if(this.x > TankFrame.GAME_WIDTH - this.width - this.width / 2) x = TankFrame.GAME_WIDTH - this.width - this.width / 2;
		if(this.y > TankFrame.GAME_HEIGHT - this.height - this.height / 2) y = TankFrame.GAME_HEIGHT - this.height - this.height / 2;
	}

	private void randomDirection() {
		this.dir = Direction.values()[random.nextInt(4)];
	}

	public Direction getDir() {
		return dir;
	}
	@Override
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	@Override
	public void setMoving(boolean b) {
		this.moving = b;
	}
	@Override
	public void fire() {
		fs.fire(this);
	}

	public void die() {
		// TODO Auto-generated method stub
		this.alive  = false;
	}
}
