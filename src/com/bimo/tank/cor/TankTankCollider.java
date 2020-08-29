package com.bimo.tank.cor;

import com.bimo.tank.Bullet;
import com.bimo.tank.GameObject;
import com.bimo.tank.Tank;

public class TankTankCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		// TODO Auto-generated method stub
		if(o1 instanceof Tank && o2 instanceof Tank) {
			Tank t1 = (Tank)o1;
			Tank t2 = (Tank)o2;
			if(t1.getRectTank().intersects(t2.getRectTank())) {
				t1.back();
				t2.back();
			}
		}
		return true;
	}

}
