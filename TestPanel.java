import java.awt.GridLayout;

import javax.swing.JFrame;

public class TestPanel {

	public static void main(String[] args) throws InterruptedException {
		
		MainMenuPanel menu=new  MainMenuPanel();
		MonopolyPanel MPanel=new MonopolyPanel();
		JFrame frame=new JFrame();
		frame.setLayout(new GridLayout(1,2));
		frame.add(menu);
		frame.add(MPanel);
		frame.setVisible(true);
		
		
	}
}
