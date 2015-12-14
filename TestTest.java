import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class TestTest {

	public static void main(String[] args)  {

		Dice dice1=new Dice();
		dice1.roll();
		System.out.println(dice1.getValue());
		
		try {
			BufferedImage image1 = ImageIO.read(new File("src/piyon.jpg"));
			Token t=new Token("piyon",image1);

		
		
		JFrame frame=new JFrame();
		frame.setTitle("ERMAN Test");
		frame.setSize(115,115);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
