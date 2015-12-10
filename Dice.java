import java.util.Random;


public class Dice {
	private int faceValue=0;
	private final int MAXVALUE=6;
	private final int MINVALUE=1;
	
	public Dice()
	{
		
	}

	public void roll()
	
	{
		Random rand = new Random();
		faceValue=rand.nextInt(MAXVALUE) + MINVALUE;
	}
	
	public int getValue()
	{
		return faceValue;
	}
}
