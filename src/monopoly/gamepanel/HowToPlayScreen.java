package monopoly.gamepanel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HowToPlayScreen extends JPanel {
	int x,y;
	public JButton back;

	public HowToPlayScreen(int x,int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBounds(0, 0, x/4, y/2);

		JTextArea howToPlay = new JTextArea(
				"This is a classic simulation of the Board Game Monopoly. Each player needs an unique name to play. "
				+ "Players will roll the dice and move on the board. If any player rolls both dices equal,"
				+ " then he/she will have one more roll. If anyone rolls equal three times in a row then he/she will"
				+ " be punished in jail. Each player can buy and properties and collect rent from them. If a player collects "
				+ "all properties of the same color, then he/she can build on them to collect more rent from the visitors."
				+ " If any player has money lower than 0 or the game reaches it's the turn limit;"
				+ " The richest player will be the winner. Good Luck.");
		howToPlay.setFont(new Font("Serif", Font.BOLD, 18));
		howToPlay.setLineWrap(true);
		howToPlay.setWrapStyleWord(true);
		howToPlay.setEditable(false);

		howToPlay.setBounds(x/40, y/20, 8*x/40, 15*y/40);
		add(howToPlay);

		back = new JButton("BACK TO MENU");
		back.setSize(200, 50);
		back.setBounds(3*x / 40+x/80, 18*y/40, 3*x/40, y/40);
		add(back);

		setVisible(true);
	}
}
