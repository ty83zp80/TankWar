package com.bimo.tank;

public enum DefaultFireStrategy implements FireStrategy {
	INSTANCE;
	@Override
	public void fire(Tank t) {
		int startX = t.getX() + t.getWidth()/2 - Bullet.WIDTH / 2;
		int startY = t.getY() + t.getHeight() / 2 - Bullet.HEIGHT / 2;
		new Bullet(startX, startY,t.getDir(),t.getGroup(),t.f);
	}
}
