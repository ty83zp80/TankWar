package com.bimo.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
	public static void main(String[] args) throws InterruptedException {
		TankFrame f = new TankFrame();
		
		for(int i = 0; i<10; i++) {
			f.enemyTanks.add(new Tank(50 + i * 80, 150, 50, 50, Direction.DOWN ,Group.BAD, 1 , f));
		}
		while(true) {
			Thread.sleep(50);
			f.repaint();
		}
	}
	
}
