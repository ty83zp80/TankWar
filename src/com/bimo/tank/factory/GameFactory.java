package com.bimo.tank.factory;

import com.bimo.tank.Direction;
import com.bimo.tank.GameModel;
import com.bimo.tank.Group;
import com.bimo.tank.TankFrame;

public abstract class GameFactory {
	public abstract BaseBullet createBullet(int x, int y, Direction dir,Group group,GameModel gm);
	public abstract BaseTank createTank(int x, int y, int width, int height, Direction dir,Group group, int speed, GameModel gm);
	public abstract BaseExplode createExplode(int x, int y, GameModel gm);
}
