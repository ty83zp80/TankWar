package com.bimo.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		TankFrame f = new TankFrame();
		
		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		
		while(true) {
			Thread.sleep(50);
			f.repaint();
		}
	}
	
}
