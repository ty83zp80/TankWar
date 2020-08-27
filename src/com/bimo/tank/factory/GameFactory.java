package com.bimo.tank.factory;

import com.bimo.tank.Direction;
import com.bimo.tank.Group;
import com.bimo.tank.TankFrame;

public abstract class GameFactory {
	public abstract BaseBullet createBullet(int x, int y, Direction dir,Group group,TankFrame f);
	public abstract BaseTank createTank(int x, int y, int width, int height, Direction dir,Group group, int speed, TankFrame f);
	public abstract BaseExplode createExplode(int x, int y, TankFrame f);
}
