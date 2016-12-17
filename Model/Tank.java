package Model;

public abstract class Tank extends GameBody {

	private int shootSpeed;
	private int moveSpeed;
	protected boolean isDoubleShot;

	public Tank( int x, int y){
		super(x, y);
		this.isDoubleShot = false;
	}

	public boolean isDoubleShot() { return isDoubleShot; }

	public void move(int x, int y) {
		setX( getX() + x);
		setY( getY() + y);
	}

}