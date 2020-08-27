package com.bimo.tank;

import com.bimo.tank.factory.BaseTank;

public enum DefaultFireStrategy implements FireStrategy {
	INSTANCE;
	@Override
	public void fire(BaseTank t) {
		int startX = t.getX() + t.getWidth()/2 - Bullet.WIDTH / 2;
		int startY = t.getY() + t.getHeight() / 2 - Bullet.HEIGHT / 2;
		//new Bullet(startX, startY,t.getDir(),t.getGroup(),t.f);
		t.f.gf.createBullet(startX, startY,t.getDir(), t.getGroup(), t.f);
	}
}
