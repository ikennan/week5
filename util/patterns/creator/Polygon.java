package util.patterns.creator;

public abstract class Polygon implements Shape{
	String type ;
	
	public abstract void draw();
	public Shape getShape(String type) {
		Shape shape;
		
		if(type.equalsIgnoreCase("Triangle"))
			return new Traingle();
		return null;
	}

}
