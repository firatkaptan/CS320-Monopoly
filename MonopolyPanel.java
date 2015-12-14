import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.Timer;



public class MonopolyPanel extends JPanel{
	JLabel IbMoney=new JLabel("Money");
	JLabel IbTime=new JLabel("Time");
	JLabel IbCurrentTurn=new JLabel("Turn");
	JPanel sidePanel=new JPanel();
	JTextPane txtPanelConsole=new JTextPane();
	
	
	public MonopolyPanel()
	{
		this.add(IbMoney);
		this.add(IbTime);
		this.add(IbCurrentTurn);
		this.add(sidePanel);
		this.add(txtPanelConsole);
		Timer timer=new Timer(1,new TimerListener());
		timer.start();
	}
	
	
	public class TimerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			 repaint();
			
		}
		
	}

}
