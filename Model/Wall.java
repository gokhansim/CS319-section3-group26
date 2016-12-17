package Model;

public abstract class Wall extends GameBody{

	private int x;
	private int y;

	public Wall( int x, int y){
		super(x, y);
	}

	public abstract int getType();
}
