package Model;

public abstract class Tank extends GameBody {

	private int shootSpeed;
	private int moveSpeed;
	private int x;
	private int y;
	protected boolean isDoubleShot;

	public Tank( int x, int y){
		this.x = x;
		this.y = y;
		this.isDoubleShot = false;
	}

	public int getX(){
		return this.y;
	}

	public int getY() {
		return this.y;
	}

	public void setX( int x){
		this.x = x;
	}

	public void setY( int y) {
		this.y = y;
	}

	public boolean getShootAmount() { return isDoubleShot; }

	public void move(int x, int y) {
		setX( getX() + x);
		setY( getY() + y);
	}

	public abstract void getDestroyed(GameEngine engine);
}