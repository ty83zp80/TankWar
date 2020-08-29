package com.bimo.tank.cor;

import com.bimo.tank.GameObject;

public interface Collider {
	boolean collide(GameObject o1, GameObject o2);
	
}
