package com.bimo.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
	public static void main(String[] args) throws InterruptedException {
		TankFrame f = new TankFrame();
		
		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		int enemyTankCount = Integer.parseInt((String)PropertyMgr.getInstance().get("enemyTankQty")) ;
		for(int i = 0; i<enemyTankCount; i++) {
			//f.enemyTanks.add(new Tank(50 + i * 80, 150, 50, 50, Direction.DOWN ,Group.BAD, 1 , f));
			f.enemyTanks.add(f.gf.createTank(50 + i * 80, 150, 50, 50, Direction.DOWN ,Group.BAD, 1 , f));
		}
		while(true) {
			Thread.sleep(50);
			f.repaint();
		}
	}
	
}
