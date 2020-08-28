package com.bimo.tank;

import java.awt.Graphics;

import com.bimo.tank.factory.BaseExplode;

public class Explode extends BaseExplode {

	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	private int x;
	private int y;
	
	private boolean alive = true;
	
	private TankFrame f;

	private int step = 1;
	GameModel gm;
	public Explode(int x, int y, GameModel gm) {
		super();
		this.x = x;
		this.y = y;
		this.gm = gm;
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		if(step >= ResourceMgr.explodes.length) {
			alive = false;
			step = 0;
			gm.exp.remove(this);
		}
	}
	
}
