package monopoly.gamepanel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MainMenu extends JPanel{
	
	public JTextField txtFieldPlayer2,txtFieldPlayer3,txtFieldPlayer1,txtFieldPlayer4;
	public JComboBox<Integer> comboBox,comboBox1,comboBox2,comboBox3,comboBox4;
	public JButton btnHowToPlay,btnStart,btnExit;
	int x,y;
	Color[] colors={Color.black,Color.red,Color.blue,Color.green};
	public MainMenu(int x,int y){
		this.x=x;
		this.y=y;
		setBounds(0, 0, x/4, y/2);
		setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Player1 Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		
		txtFieldPlayer1 = new JTextField("w");
		panel.add(txtFieldPlayer1);
		txtFieldPlayer1.setColumns(10);
		comboBox1 = new JComboBox(colors);
		comboBox1.setRenderer(new MyCellRenderer());
		panel.add(comboBox1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Player2 Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1);
		
		txtFieldPlayer2 = new JTextField("d");
		panel_1.add(txtFieldPlayer2);
		txtFieldPlayer2.setColumns(10);
		comboBox2 = new JComboBox(colors);
		comboBox2.setRenderer(new MyCellRenderer());
		panel_1.add(comboBox2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Player3 Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2);
		
		txtFieldPlayer3 = new JTextField("s");
		panel_2.add(txtFieldPlayer3);
		txtFieldPlayer3.setColumns(10);
		comboBox3 = new JComboBox(colors);
		comboBox3.setRenderer(new MyCellRenderer());
		panel_2.add(comboBox3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Player4 Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_3);
		
		txtFieldPlayer4 = new JTextField("a");
		panel_3.add(txtFieldPlayer4);
		txtFieldPlayer4.setColumns(10);
		comboBox4 = new JComboBox(colors);
		comboBox4.setRenderer(new MyCellRenderer());
		panel_3.add(comboBox4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Set Turn Limit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		comboBox = new JComboBox<Integer>();
		panel_4.add(comboBox);
		comboBox.addItem(50);
		comboBox.addItem(100);
		comboBox.addItem(200);
		
		btnHowToPlay = new JButton("How to Play ?");
		add(btnHowToPlay);
		
		btnStart = new JButton("Start");
		add(btnStart);
		
		btnExit = new JButton("Exit");
		add(btnExit);
		setVisible(true);
	}

}
