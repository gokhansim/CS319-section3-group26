package Model;

public class SteelWall extends Wall{
	
	private int type;
	
	public SteelWall(int x, int y){
		super(x,y);
		this.type = 3;

	}

	public int getType(){
		return type;
	}

}
