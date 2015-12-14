package monopoly.main;

import javax.swing.JFrame;

import monopoly.controller.MainController;

public class Main {

	public static JFrame frame;
	
	public static void main(String args[]) {		
		frame = new JFrame("Monopoly");
		MainController controller = new MainController();
		frame.getContentPane().add(controller.getMenu());
		frame.setSize(400, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
