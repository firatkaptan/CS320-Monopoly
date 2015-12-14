import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenuPanel extends JPanel{

	private JComboBox cBoxTurnNumber;
	private JTextField textFieldP_1Name=new JTextField();
	private JTextField textFieldP_2Name=new JTextField();
	private JTextField textFieldP_3Name=new JTextField();
	private JTextField textFieldP_4Name=new JTextField();
	
	public MainMenuPanel()
	{
		//ADD CONTOLLER HERE
		
		this.setLayout(new GridLayout(2,2));
		this.add(textFieldP_1Name);
		this.add(textFieldP_2Name);
		this.add(textFieldP_3Name);
		this.add(textFieldP_4Name);
		

		
		
	}
	
	
	
	
}
