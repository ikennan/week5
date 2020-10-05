import acm.program.*;
import acm.graphics.*;
import acm.util.*; 

//The is program draws 10 circles that are randomly assigned different sizes, positions, and colors. 
//All the circles must fit inside the display.


public class CirclingRandomly extends GraphicsProgram {
 private static final double MAX_RADIUS = 50;
 
 private static final int NCIRCLES = 10;

 private static final double MIN_RADIUS = 5;

 
 	public void run() {
 		for (int i = 0; i < NCIRCLES; i++) {
 			double r = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
 			double x = rgen.nextDouble(0, getWidth() - 2 * r);
 			double y = rgen.nextDouble(0, getHeight() - 2 * r);
 
 			GOval round = new GOval (x, y, 2 * r, 2 * r);
 
 			round.setFilled(true);
 
 			round.setColor(rgen.nextColor());
 
 			add(round);
 }
 }

/* Private instance variable */
 private RandomGenerator rgen = RandomGenerator.getInstance();
} 


