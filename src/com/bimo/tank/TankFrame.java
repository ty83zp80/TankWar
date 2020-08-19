package com.bimo.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	int x = 200, y = 200;
	public TankFrame() {
		setResizable(false);
		setTitle("Tank War");
		setVisible(true);
		setBounds(100, 100, 800, 600);
		
		this.addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	@Override
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
	}
	
	class MyKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			//x += 200;
			int key = e.getKeyCode();
			switch(key) {
				case KeyEvent.VK_LEFT: 
					x-=5;
					break;
				case KeyEvent.VK_RIGHT:
					x+=5;
					break;
				case KeyEvent.VK_UP:
					y -= 5;
					break;
				case KeyEvent.VK_DOWN:
					y+=5;
					break;
				default:
					break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
	}
}
