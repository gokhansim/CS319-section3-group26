package Model;

public class SacredObject extends GameBody{
	
	private int xPosition;
	private int yPosition;
	private int type;
	
	public SacredObject(){
		x = xPosition;
		y = yPosition;
		type = 4;
	}
	public int getTypeSacred(){
		return type;
	}
	
}
