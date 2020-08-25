package com.bimo.tank;

import java.awt.Graphics;

public class Explode {

	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	private int x;
	private int y;
	
	private boolean alive = true;
	
	private TankFrame f;

	private int step = 1;
	public Explode(int x, int y, TankFrame f) {
		super();
		this.x = x;
		this.y = y;
		this.f = f;
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		if(step >= ResourceMgr.explodes.length) {
			alive = false;
			step = 0;
			f.exp.remove(this);
		}
	}
	
}
