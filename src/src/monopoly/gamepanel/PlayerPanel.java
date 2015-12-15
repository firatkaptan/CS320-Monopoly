package monopoly.gamepanel;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import monopoly.model.Player;
import monopoly.model.Property;

public class PlayerPanel extends JPanel{
	int x,y;
	public JPanel panel0,panel1,panel2,panel3;
	public JLabel name0,name1,name2,name3,money0,money1,money2,money3,properties0,properties1,properties2,properties3;
	public PlayerPanel(int x,int y,Player[] players){
		this.x=x;
		this.y=y;
		setLayout(new GridLayout(2, 2));
		setBounds(y*7/8+5,7*y/30,x-y,19*y/30);
		setVisible(true);
		
		panel0=new JPanel();
		name0=new JLabel();
		properties0= new JLabel();
		properties0.setBounds(0, 0, 1111, 1111);
		money0=new JLabel();
		panel0.setLayout(new GridLayout(3,1));
		panel0.setBorder(new TitledBorder(null, "Player: 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel0.add(name0);
		panel0.add(money0);
		panel0.add(properties0);
		add(panel0);
		
		panel1=new JPanel();
		name1=new JLabel();
		properties1= new JLabel();
		money1=new JLabel();
		panel1.setLayout(new GridLayout(3,1));
		panel1.setBorder(new TitledBorder(null, "Player: 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.add(name1);
		panel1.add(money1);
		panel1.add(properties1);
		add(panel1);
		
		panel2=new JPanel();
		name2=new JLabel();
		properties2= new JLabel();
		money2=new JLabel();
		panel2.setLayout(new GridLayout(3,1));
		panel2.setBorder(new TitledBorder(null, "Player: 3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.add(name2);
		panel2.add(money2);
		panel2.add(properties2);
		add(panel2);
		
		panel3=new JPanel();
		name3=new JLabel();
		properties3= new JLabel();
		money3=new JLabel();
		panel3.setLayout(new GridLayout(3,1));
		panel3.setBorder(new TitledBorder(null, "Player: 4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.add(name3);
		panel3.add(money3);
		panel3.add(properties3);
		add(panel3);
		update(players);
	}
	public void setName(JLabel l,Player p){
		l.setText("Name: "+p.getName());
	}
	public void setMoney(JLabel l,Player p){
		l.setText("Money: "+p.getMoney());
	}
	public void setProperties(JLabel l, Player p){
		String properties="";
		for(int i=0;i<p.properties.size();i++){
			properties+=p.properties.get(i).name+" ";
		}
		l.setText("Properties : "+properties);
	}
	public void update(Player[] players){
		setName(name0,players[0]);
		setName(name1,players[1]);
		setName(name2,players[2]);
		setName(name3,players[3]);
		setMoney(money0,players[0]);
		setMoney(money1,players[1]);
		setMoney(money2,players[2]);
		setMoney(money3,players[3]);
		setProperties(properties0,players[0]);
		setProperties(properties1,players[1]);
		setProperties(properties2,players[2]);
		setProperties(properties3,players[3]);
	}
}
