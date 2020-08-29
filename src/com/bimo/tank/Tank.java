package com.bimo.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import com.bimo.tank.factory.BaseTank;

public class Tank extends BaseTank {

	private Direction dir;
	private int speed;
	private int width;
	private int height;

	private boolean moving = true;
	private boolean alive = true;
	private Group group;

	private Random random = new Random();
	private FireStrategy fs;
	private int oldX;
	private int oldY;
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

	public Tank(int x, int y, int width, int height, Direction dir, Group group, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.speed = speed;
		this.width = width;

		rectTank.x = x;
		rectTank.y = y;
		rectTank.width = width;
		rectTank.height = height;

		if (group == Group.GOOD) {
			fs = FourBulletsFireStrategy.INSTANCE;
		} else {
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
		if (!alive && group == Group.BAD)
			GameModel.getInstance().remove(this);

		switch (dir) {
		case LEFT:
			if (group == Group.GOOD) {
				g.drawImage(ResourceMgr.goodTankL, x, y, null);
			} else {
				g.drawImage(ResourceMgr.badTankL, x, y, null);
			}
			break;
		case RIGHT:
			if (group == Group.GOOD) {
				g.drawImage(ResourceMgr.goodTankR, x, y, null);
			} else {
				g.drawImage(ResourceMgr.badTankR, x, y, null);
			}
			break;
		case DOWN:
			if (group == Group.GOOD) {
				g.drawImage(ResourceMgr.goodTankD, x, y, null);
			} else {
				g.drawImage(ResourceMgr.badTankD, x, y, null);
			}
			break;
		case UP:
			if (group == Group.GOOD) {
				g.drawImage(ResourceMgr.goodTankU, x, y, null);
			} else {
				g.drawImage(ResourceMgr.badTankU, x, y, null);
			}
			break;
		default:
			break;
		}
		move();
	}

	private void move() {
		if (!moving)
			return;
		oldX = x;
		oldY = y;
		switch (dir) {
		case LEFT:
			x -= speed;
			boundsCheck();
			break;
		case RIGHT:
			x += speed;
			boundsCheck();
			break;
		case UP:
			y -= speed;
			boundsCheck();
			break;
		case DOWN:
			y += speed;
			boundsCheck();
			break;
		default:
			break;
		}

		rectTank.x = x;
		rectTank.y = y;
		if (this.group == Group.BAD && random.nextInt(10) > 8 && group == Group.BAD)
			fs.fire(this);
		if (this.group == Group.BAD && random.nextInt(100) > 95)
			randomDirection();
	}

	private void boundsCheck() {
		if (this.x < this.width / 2)
			x = this.width / 2;
		if (this.y < this.height / 2)
			y = this.height / 2;
		if (this.x > TankFrame.GAME_WIDTH - this.width - this.width / 2)
			x = TankFrame.GAME_WIDTH - this.width - this.width / 2;
		if (this.y > TankFrame.GAME_HEIGHT - this.height - this.height / 2)
			y = TankFrame.GAME_HEIGHT - this.height - this.height / 2;
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
		this.alive = false;
	}

	public void back() {
		// TODO Auto-generated method stub
		x = oldX;
		y = oldY;
	}
	
	public void stop() {
		moving =false;
	}

}
