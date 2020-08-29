package com.bimo.tank.cor;

import com.bimo.tank.Bullet;
import com.bimo.tank.GameObject;
import com.bimo.tank.Tank;
import com.bimo.tank.factory.BaseBullet;
import com.bimo.tank.factory.BaseTank;

public class BulletTankCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		// TODO Auto-generated method stub
		if(o1 instanceof Bullet && o2 instanceof Tank) {
			Bullet b = (Bullet)o1;
			Tank t =(Tank)o2;
			return !b.collideWidth(t);
		}else if(o1 instanceof Tank && o2 instanceof Bullet) {
			return collide(o2,o1);
		}
		return true;
	}

}
