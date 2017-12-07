package com.kittleapps.ExcellRecreation;

import java.awt.Toolkit;

public class Storage {
	public static int
		windowSizeX, windowSizeY,
		windowPositionX, windowPositionY,
		DaysToDocument
	;
	public static double PayPerMile = 0.50;

	public static void init() {
		windowSizeX = 950;
		windowSizeY = 650;
		DaysToDocument = 31;
		windowPositionX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-(windowSizeX/2));
		windowPositionY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-(windowSizeY/2));
	}
}
