package monopoly.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Map extends JPanel implements MouseListener{
	HashMap<String, Square> squareMap = new HashMap<String,Square>();
	public Square[] squareArray=new Square[28];
	public JButton roll;
	int y;
	public Dice d1,d2;
	Player[] players;
	Token[] tokens;
	public Map(int y,Player[] players,Token[] tokens){
		this.tokens=tokens;
		this.players=players;
		this.y=y;
		this.setSize(y, y);
		this.setLayout(new BorderLayout());
		System.out.println(y);
		MapCreator();
		initTokens();
		
		createDices();
		
		drawMap();
		
		System.out.println(((Property) squareMap.get("ISTANBUL")).getRent());
		
		repaint();
		setVisible(true);
	}
	private void initTokens() {
		for(int i=0;i<tokens.length;i++){
			add(tokens[i]);
			tokens[i].setPosition(0);
			tokens[i].move(squareArray[0]);
		}
	}
	void addSquare(Square s,int i){
		squareArray[i]=s;
		squareMap.put(s.name, s);
	}
	void createDices(){
		d1=new Dice(y,0);
		d1.setLocation(19*y/48,y*5/8);
		d2=new Dice(y,0);
		d2.setLocation(25*y/48,y*5/8);
		roll=new JButton("ROLL");
		roll.setLocation(19*y/48,y*5/8+5*y/48);
		roll.setSize(10*y/48,y/24);
		add(roll);
		add(d1);
		add(d2);
	}
	void drawMap(){
		for(int i=0;i<squareArray.length;i++){
			squareArray[i].addMouseListener(this);
			add(squareArray[i]);
		}
	}

	void MapCreator(){
		File file = new File("src/squares.txt");

		try {

			Scanner sc = new Scanner(file);
			int k=0;
			while (sc.hasNext()) {
				String i = sc.next();
				if(i.equals("P")){
					Property p=new Property(y, k, new Color(sc.nextInt(), sc.nextInt(), sc.nextInt()), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
					addSquare(p,k);
					k++;
				}else if(i.equals("G")){
					GoToJail g=new GoToJail(y, k);
					addSquare(g,k);
					k++;
				}else if(i.equals("C")){
					Chance c=new Chance(y, k);
					addSquare(c,k);
					k++;
				}else if(i.equals("L")){
					ParkingLot l=new ParkingLot(y, k);
					addSquare(l,k);
					k++;
				}else if(i.equals("J")){
					Jail j=new Jail(y, k);
					addSquare(j,k);
					k++;
				}else if(i.equals("S")){
					Start s=new Start(y, k);
					addSquare(s,k);
					k++;
				}
				
			}
			sc.close();

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void mouseClicked(MouseEvent event){
		
	}
	@Override
	public void mouseEntered(MouseEvent event) {
		if(event.getSource() instanceof Property){
			System.out.println(((Property) event.getSource()).getRent());;
		}

	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}


