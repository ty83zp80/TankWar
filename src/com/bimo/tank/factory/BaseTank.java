package com.bimo.tank.factory;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.bimo.tank.Direction;
import com.bimo.tank.GameModel;
import com.bimo.tank.GameObject;
import com.bimo.tank.Group;
import com.bimo.tank.TankFrame;

public abstract class BaseTank extends GameObject {

	public abstract int getX();

	public abstract int getWidth();

	public abstract int getY();

	public abstract Direction getDir();

	public abstract Group getGroup();

	public abstract int getHeight();

	public abstract Rectangle getRectTank();

	public abstract void die();

	public abstract void paint(Graphics g);
	public abstract void fire();

	public abstract void setMoving(boolean b);

	public abstract void setDir(Direction right);

}
