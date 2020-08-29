package com.bimo.tank;

import java.awt.Graphics;

import com.bimo.tank.factory.BaseExplode;

public class Explode extends BaseExplode {

	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	
	private boolean alive = true;
	
	private TankFrame f;

	private int step = 1;
	public Explode(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		GameModel.getInstance().add(this);
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		if(step >= ResourceMgr.explodes.length) {
			alive = false;
			step = 0;
			GameModel.getInstance().remove(this);
		}
	}
	
}
