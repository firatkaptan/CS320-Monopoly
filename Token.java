

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Token extends JPanel{
	private String name="";
	private BufferedImage Image;
	private int width=5;
	private int height=5;
	
	Token(String name,BufferedImage Image)
	{
		this.name=name;
		this.Image=Image;
		this.setSize(width, height);
		
	}
	
	public String toString()
	{
		return name+"token";
	}
	
	protected void paintComponent (Graphics g) 
	{
		g.drawImage(Image, 0, 0, null);
	}
	
	
}
