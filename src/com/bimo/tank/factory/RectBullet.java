package com.bimo.tank.factory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.bimo.tank.Direction;
import com.bimo.tank.Explode;
import com.bimo.tank.GameModel;
import com.bimo.tank.Group;
import com.bimo.tank.ResourceMgr;
import com.bimo.tank.Tank;
import com.bimo.tank.TankFrame;

public class RectBullet extends BaseBullet {

	private static final int SPEED = 10;
	public static final int WIDTH = ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
	private int x,y ;
	private Direction dir;
	private boolean alive = true;
	private GameModel gm;
	private Group group;
	
	Rectangle rectBullet = new Rectangle();
	public RectBullet(int x, int y, Direction dir,Group group,GameModel gm) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.gm = gm;
		
		rectBullet.x = x;
		rectBullet.y = y;
		rectBullet.width = WIDTH;
		rectBullet.height = HEIGHT;
		
		gm.bList.add(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if(!alive) {
			gm.bList.remove(this);
		}
		
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 10, 10);
		g.setColor(c);
		move();
	}

	public void move() {
		switch(dir) {
			case LEFT: 
				x-=SPEED;
				break;
			case RIGHT: 
				x += SPEED; 
				break;
			case UP: 
				y -=SPEED ;
				break;
			case DOWN: 
				y += SPEED; 
				break;
			default : break;
		}
		rectBullet.x = x;
		rectBullet.y = y;
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH  || y> TankFrame.GAME_HEIGHT) {
			alive = false;
		}
	}

	@Override
	public void collideWidth(BaseTank tank) {
		// TODO Auto-generated method stub
		if(this.group == tank.getGroup()) return;
		//TODO: 需要创建一个公用的Rectangle，来分别装在
		Rectangle rectTank = tank.getRectTank();
		if(rectBullet.intersects(rectTank)) {
			tank.die();
			this.die();
			int eX = tank.getX() + tank.getWidth() / 2 - Explode.WIDTH / 2;
			int eY = tank.getY() + tank.getHeight() / 2 - Explode.HEIGHT / 2;
			gm.exp.add(gm.gf.createExplode(eX, eY, gm));
		}
	}

	private void die() {
		// TODO Auto-generated method stub
		this.alive = false;
	}

}
