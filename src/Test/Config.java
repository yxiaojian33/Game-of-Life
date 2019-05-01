package Test;

import java.awt.Color;

import javax.swing.JColorChooser;

public class Config {
	public static Color alive=Color.blue;
	public static Color death=Color.white;
	public static int freshtime=100;
	public static void setcolor()
	{
		 JColorChooser colo=new JColorChooser();
		 alive=colo.showDialog(null, "ÑÕÉ«Ñ¡È¡", Color.black);
		 ControlPnl.cnt.setForeground(alive);
		 ControlPnl.times.setForeground(alive);
	}
	public static void settime(int time)
	{
		freshtime=time;
	}
}
