package monopoly.gamepanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import monopoly.controller.MainController;

public class Monopoly extends JPanel{

	public JPanel stats;
	public JLabel lblCurrentPlayer;
	public JLabel lblTurnLimit;
	public JLabel lblCurrentTurn;
	private JScrollPane scrollPane;
	public JTextPane txtpnConsole;
	public JLabel lblDice1;
	public JLabel lblDice2;


	public Monopoly(MainController controller){
		setLayout(new BorderLayout());
		Map map = controller.map;
		add(map);
		stats = new JPanel();	
		add(stats, BorderLayout.EAST);
		stats.setLayout(new GridLayout(5, 2, 0, 0));

		lblDice1 = new JLabel();
		lblDice1.setIcon(new ImageIcon(Monopoly.class.getResource("/dice_1.png")));
		stats.add(lblDice1);

		lblDice2 = new JLabel();
		lblDice2.setIcon(new ImageIcon(Monopoly.class.getResource("/dice_1.png")));
		stats.add(lblDice2);

		lblTurnLimit = new JLabel("Number of Turns : ");
		stats.add(lblTurnLimit);
		
		lblCurrentTurn = new JLabel("Current Turn : ");
		stats.add(lblCurrentTurn);
		
		lblCurrentPlayer = new JLabel("Current Player : ");
		stats.add(lblCurrentPlayer);
		
		scrollPane = new JScrollPane();
		stats.add(scrollPane);
		
		txtpnConsole = new JTextPane();
		txtpnConsole.setText("Console\nGame Started ...");
		txtpnConsole.setEditable(false);
		scrollPane.setViewportView(txtpnConsole);
		
	}
}
