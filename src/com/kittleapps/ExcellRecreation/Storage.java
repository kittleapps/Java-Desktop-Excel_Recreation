package com.kittleapps.ExcellRecreation;

import java.awt.Toolkit;

public class Storage {
	public static int 
		windowSizeX, windowSizeY,
		windowPositionX, windowPositionY
	;

	public static void init() {
		windowSizeX = 950;
		windowSizeY = 650;
		windowPositionX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(windowSizeX/2));
		windowPositionY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(windowSizeY/2));
	}
}
