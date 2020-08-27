package com.bimo.tank.factory;

import java.awt.Graphics;

import com.bimo.tank.Tank;

public abstract class BaseBullet {

	public abstract void paint(Graphics g);

	public abstract void collideWidth(BaseTank tank);

}
