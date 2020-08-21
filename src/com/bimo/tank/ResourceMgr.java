package com.bimo.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {

	public static BufferedImage tankL ;
	public static BufferedImage tankU;
	public static BufferedImage tankR;
	public static BufferedImage tankD;
	
	public static BufferedImage bulletL ;
	public static BufferedImage bulletU;
	public static BufferedImage bulletR;
	public static BufferedImage bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
			for(int i = 0; i< explodes.length; i++) {
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+ (i+1) +".gif"));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
