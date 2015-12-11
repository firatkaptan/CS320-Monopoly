package monopoly.model;

import java.util.HashMap;

import javax.swing.JPanel;

public class Map extends JPanel{
	HashMap<String, Square> squareMap = new HashMap<String,Square>();
	Square[] squareArray=new Square[40];
	public Map(){
		
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
