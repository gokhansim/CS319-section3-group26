package Model;

public class SteelWall extends Wall{

	private int type;
	private static final int ID = 5;

	public SteelWall(int x, int y){
		super(x,y);
		this.type = 3;
	}

	public int getType(){
		return type;
	}
	public int getId() { return ID; }

}
