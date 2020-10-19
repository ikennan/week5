import acm.graphics.GImage;
import acm.program.ConsoleProgram;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FlipPic extends ConsoleProgram{

	private static GImage FlipPic(GImage image) 
	
	public void run() {
		

	
	
	//{
	//	private static GImage image;
		//private static Scanner input;
		//private static String fileName;
		
		
		//image = new GImage ("themilkmaid.jpg");
		
		//add(flipImage(image));
	
	private FlipPic(GImage image) {	
	
		
		int[][] picarray = image.getPixelArray();
		int width = picarray[0].length;
		int height = picarray.length;
		for (int row = 0; row < height; row++) {
			for (int p1 = 0; p1 < width / 2; p1++) {
				int p2 = width - p1 - 1;
				int temp = picarray[row][p1];
				picarray[row][p1] = picarray[row][p2];
				picarray[row][p2] = temp;
			}
		}
		return new GImage(picarray);
	}
	
}
