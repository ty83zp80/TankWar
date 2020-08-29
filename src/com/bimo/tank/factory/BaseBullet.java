package com.bimo.tank.factory;

import java.awt.Graphics;

import com.bimo.tank.GameModel;
import com.bimo.tank.GameObject;
import com.bimo.tank.Tank;

public abstract class BaseBullet extends GameObject {

	public abstract boolean collideWidth(BaseTank tank);

}
