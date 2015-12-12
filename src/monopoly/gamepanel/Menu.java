package monopoly.gamepanel;
import javax.swing.JPanel;
import monopoly.controller.MainController;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Menu extends JPanel{
	public JTextField txtFieldPlayer4;
	public JTextField txtFieldPlayer1;
	public JTextField txtFieldPlayer2;
	public JTextField txtFieldPlayer3;
	public JComboBox<Integer> comboBox;
	
	public Menu(MainController controller){
		setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Player1 Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		
		txtFieldPlayer1 = new JTextField();
		panel.add(txtFieldPlayer1);
		txtFieldPlayer1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Player2 Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1);
		
		txtFieldPlayer2 = new JTextField();
		panel_1.add(txtFieldPlayer2);
		txtFieldPlayer2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Player3 Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2);
		
		txtFieldPlayer3 = new JTextField();
		panel_2.add(txtFieldPlayer3);
		txtFieldPlayer3.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Player4 Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_3);
		
		txtFieldPlayer4 = new JTextField();
		panel_3.add(txtFieldPlayer4);
		txtFieldPlayer4.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Set Turn Limit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		comboBox = new JComboBox<Integer>();
		panel_4.add(comboBox);
		comboBox.addItem(50);
		comboBox.addItem(100);
		comboBox.addItem(200);
		
		JButton btnHowToPlay = new JButton("How to Play ?");
		add(btnHowToPlay);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.menuController.play(controller);
			}
		});
		add(btnStart);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnExit);
		
	}

}
