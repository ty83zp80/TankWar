package com.bimo.tank.factory;

import com.bimo.tank.Bullet;
import com.bimo.tank.Direction;
import com.bimo.tank.Explode;
import com.bimo.tank.GameModel;
import com.bimo.tank.Group;
import com.bimo.tank.Tank;
import com.bimo.tank.TankFrame;

public class DefaultFactory extends GameFactory {

	public DefaultFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BaseBullet createBullet(int x, int y, Direction dir, Group group, GameModel gm) {
		// TODO Auto-generated method stub
		return new Bullet(x,y,dir,group,gm);
	}

	@Override
	public BaseTank createTank(int x, int y, int width, int height, Direction dir, Group group, int speed,
			GameModel gm) {
		// TODO Auto-generated method stub
		return new Tank(x,y,width,height,dir,group,speed,gm);
	}

	@Override
	public BaseExplode createExplode(int x, int y, GameModel gm) {
		// TODO Auto-generated method stub
		return new Explode(x,y,gm);
	}


}
