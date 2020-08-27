package com.bimo.tank.factory;

import com.bimo.tank.Bullet;
import com.bimo.tank.Direction;
import com.bimo.tank.Explode;
import com.bimo.tank.Group;
import com.bimo.tank.Tank;
import com.bimo.tank.TankFrame;

public class RectFactory extends GameFactory {

	public RectFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BaseBullet createBullet(int x, int y, Direction dir, Group group, TankFrame f) {
		// TODO Auto-generated method stub
		return new RectBullet(x,y,dir,group,f);
	}

	@Override
	public BaseTank createTank(int x, int y, int width, int height, Direction dir, Group group, int speed,
			TankFrame f) {
		// TODO Auto-generated method stub
		return new RectTank(x,y,width,height,dir,group,speed,f);
	}

	@Override
	public BaseExplode createExplode(int x, int y, TankFrame f) {
		// TODO Auto-generated method stub
		return new RectExplode(x,y,f);
	}

}
