package com.bimo.tank;

public enum FourBulletsFireStrategy implements FireStrategy{
	INSTANCE;
	@Override
	public void fire(Tank t) {
		int startX = t.getX() + t.getWidth()/2 - Bullet.WIDTH / 2;
		int startY = t.getY() + t.getHeight() / 2 - Bullet.HEIGHT / 2;
		Direction[] dirs = Direction.values();
		for(Direction dir : dirs) {
			new Bullet(startX, startY,dir,t.getGroup(),t.f);
		}
	}
}
