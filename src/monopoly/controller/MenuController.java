package monopoly.controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import monopoly.gamepanel.Map;
import monopoly.main.Main;

public class MenuController {

	
	public void play(MainController controller){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Main.frame.setSize(dim.width-120,dim.height-120);
		Main.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		int width = Main.frame.getWidth();
		int height = Main.frame.getHeight();
		controller.map = new Map(height, controller);
		controller.setView(controller.map, width, height);
	}
}
