package Model;

public class Place {
	private int x;
	private int y;
	
	//constructor
	public Place(int x, int y){
		this.x = x;
		this.y = y;
	}

	//get methods
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	//set methods
	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

}
