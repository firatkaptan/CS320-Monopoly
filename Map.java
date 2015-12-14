package monopoly.model;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map extends JFrame{
	JPanel gamePanel=  new JPanel();
	HashMap<String, Square> squareMap = new HashMap<String,Square>();
	Square[] squareArray=new Square[40];
	public Map(){
		setSize(500, 700);
		setLayout(null);
		setTitle("Welcome to MonoPoly game!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		gamePanel.setVisible(true);
		add(gamePanel);
		setVisible(true);
	}
	void addSquare(Square s,int i){
		squareArray[i]=s;
		squareMap.put(s.name, s);
	}
	void drawMap(){
		for(int i=0;i<squareArray.length;i++){
			draw(squareArray[i]);
		}
	}
	void draw(Square square){
		
	}
}
