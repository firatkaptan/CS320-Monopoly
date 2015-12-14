package monopoly.model;
import java.util.Random;


public class Dice {
	
	private int faceValue=0;
	
	public static final int MAXVALUE=6;
	public static final int MINVALUE=1;
	
	private Random rand = new Random();
	
	public Dice(){
		
	}

	public void roll(){
		faceValue = rand.nextInt(MAXVALUE) + MINVALUE;
	}
	
	public int getValue(){
		return faceValue;
	}
}
