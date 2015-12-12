package monopoly.gamepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JPanel;

import monopoly.controller.MainController;
import monopoly.model.Player;

public class Map extends JPanel implements MouseListener{
	HashMap<String, Square> squareMap = new HashMap<String,Square>();
	Square[] squareArray=new Square[28];
	int y;
	Player[] players;
	public Map(int y, MainController controller){
		this.y=y;
		this.setSize(y, y);
		this.setLayout(new BorderLayout());
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		System.out.println(y);
		MapCreator();
		drawMap();
		System.out.println(((Property) squareMap.get("ISTANBUL")).getRent());
		setVisible(true);
	}
	void addSquare(Square s,int i){
		squareArray[i]=s;
		squareMap.put(s.name, s);
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
	public Player getMaxMoneyPlayer() {
		Player maxplayer = null;
		for(Player player:players){
			if(maxplayer == null || maxplayer.getMoney() < player.getMoney()){
				maxplayer = player;
			}
		}
		return maxplayer;
	}
}


