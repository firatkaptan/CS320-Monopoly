package monopoly.gamepanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import monopoly.controller.MainController;
import javax.swing.SwingConstants;

public class Monopoly extends JPanel{

	public JPanel stats;
	public JLabel lblCurrentPlayer;
	
	public Monopoly(MainController controller){
		setLayout(new BorderLayout());
		Map map = controller.map;
		add(map);
		stats = new JPanel();	
		add(stats, BorderLayout.EAST);
		stats.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblTurnLimit = new JLabel("Number of Turns : ");
		stats.add(lblTurnLimit);
		
		JLabel lblCurrentTurn = new JLabel("Current Turn : ");
		stats.add(lblCurrentTurn);
		
		lblCurrentPlayer = new JLabel("Current Player : ");
		stats.add(lblCurrentPlayer);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		stats.add(lblNewLabel_2);
		
	}
}
