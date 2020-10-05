import acm.graphics.*;
import acm.program.*;
import java.awt.event.*; 


public class DrawLine extends GraphicsProgram {
	
	//this method monitors the window for any mouse inputs.
	public void run()
	{
		addMouseListeners();
	}
	
	private GLine line;
	
	public void mousePressed (MouseEvent m)
	
	{
		double s = m.getX();
		double t = m.getY();
		
		line = new GLine(s,t,s,t);
		add(line);
		
	}
	
	public void mouseDragged(MouseEvent m)
	
	{
		double s = m.getX();
		double t = m.getY();
		line.setEndPoint(s,t);
	}
	
	
}


