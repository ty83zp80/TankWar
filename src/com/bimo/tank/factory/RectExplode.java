package com.bimo.tank.factory;

import java.awt.Color;
import java.awt.Graphics;

import com.bimo.tank.TankFrame;

public class RectExplode extends BaseExplode {

	private int x;
	private int y;
	
	private boolean alive = true;
	
	private TankFrame f;

	private int step = 1;
	public RectExplode(int x, int y, TankFrame f) {
		this.x= x;
		this.y = y;
		this.f = f;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Color c= g.getColor();
		g.setColor(Color.RED);
		g.fillRect(x, y, 10*step, 10*step);
		step++;
		
		if(step >= 5) {
			f.exp.remove(this);
		}
		
		g.setColor(c);
		
		
	}

}
