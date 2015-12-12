package monopoly.gamepanel;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import monopoly.model.Map;

public class MainPanel extends JFrame{
	int x,y;
	public MainPanel(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dim.width-120,dim.height-120);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		x=getWidth();
		y=getHeight();
		setLayout(null);
		setTitle("Welcome to MonoPoly game!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Map(y));
		setVisible(true);
	}
}
