package monopoly.gamepanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import monopoly.model.Property;
import monopoly.model.Square;

public class MouseInfoPanel extends JPanel{
	public JLabel lblOwner,lblName,lblBuildings,lblRent,lblPrice,lblType;
	int x,y;
	public MouseInfoPanel(int x,int y){
		this.x=x;
		this.y=y;
		setLayout(new GridLayout(3, 2));
		setBounds(y*7/8+5+(x-y)/2, 5, (x-y)/2, 7*y/30-10);
		setBorder(new TitledBorder(null, "Square Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setVisible(true);
		
		lblName=new JLabel("");
		lblBuildings=new JLabel("");
		lblRent =new JLabel("");
		lblOwner=new JLabel("");
		lblPrice=new JLabel("");
		lblType =new JLabel("");
		
		add(lblName);
		add(lblType);		
		add(lblPrice);
		add(lblRent);
		add(lblBuildings);
		add(lblOwner);
	}
	public void empty(){
		lblName.setText("");
		lblBuildings.setText("");
		lblRent.setText("");
		lblOwner.setText("");
		lblPrice.setText("");
		lblType.setText("");
	}
	public void update(Property p){
			lblName.setText("Name : " + p.name);
			lblBuildings.setText("Buildings : "+ p.buildings);
			lblRent.setText("Rent : "+p.rent);
			if(p.hasOwner()){
				lblOwner.setText("Owner : "+p.owner.getName());
			}
			lblPrice.setText("Price : "+p.price);
			lblType.setText("Type : Property");
	}
	

}
