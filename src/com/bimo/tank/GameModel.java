package com.bimo.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.bimo.tank.cor.BulletTankCollider;
import com.bimo.tank.cor.Collider;
import com.bimo.tank.cor.ColliderChain;
import com.bimo.tank.cor.TankTankCollider;
import com.bimo.tank.factory.BaseBullet;
import com.bimo.tank.factory.BaseExplode;
import com.bimo.tank.factory.BaseTank;
import com.bimo.tank.factory.DefaultFactory;
import com.bimo.tank.factory.GameFactory;
import com.bimo.tank.factory.RectFactory;

public class GameModel extends GameObject {
	private static final GameModel INSTANCE = new GameModel();
	
	public static GameFactory gf = new DefaultFactory();
	static {
		init();
	}
	private static Tank tank ;
	
	private List<GameObject> objects = new LinkedList<>();

	ColliderChain chain = new ColliderChain();
	private GameModel() {}
	
	private static void init() {
		// TODO Auto-generated method stub
		tank = new Tank(200,400,50,50,Direction.UP,Group.GOOD,1);
		
		int enemyTankCount = Integer.parseInt((String)PropertyMgr.getInstance().get("enemyTankQty")) ;
		for(int i = 0; i<enemyTankCount; i++) {
			//f.enemyTanks.add(new Tank(50 + i * 80, 150, 50, 50, Direction.DOWN ,Group.BAD, 1 , f));
			gf.createTank(50 + i * 80, 150, 50, 50, Direction.DOWN ,Group.BAD, 1 );
		}
	}
	
	public static GameModel getInstance() {
		return INSTANCE;
	}
	
	public void add(GameObject go) {
		objects.add(go);
	}
	
	public void remove(GameObject go) {
		objects.remove(go);
	}

	public BaseTank getMainTank() {
		return this.tank;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		  Color c = g.getColor(); 
		  g.setColor(Color.WHITE); 
//		  g.drawString("子弹的数量是：" +
//		  bList.size(), 10, 50); 
//		  g.drawString("敌方坦克的数量是：" + enemyTanks.size(), 10, 70);
		  g.setColor(c);
		 
		tank.paint(g);
		
		for(int i = 0 ; i<objects.size(); i++) {
			objects.get(i).paint(g);
		}
		
		
		for(int i = 0 ; i< objects.size();i++) {
			for(int j = i+1; j<objects.size();j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				chain.collide(o1,o2);
				
			}
		}

	}

}
