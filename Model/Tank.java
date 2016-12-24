package Model;

public abstract class Tank extends GameBody {

	private int shootSpeed;
	private int moveSpeed;
	protected boolean isDoubleShot;
	
	public Tank( int x, int y){
		super(x, y);
		this.isDoubleShot = false;
		this.moveSpeed = 1;
	}
	
	public int getShootSpeed() {
		return shootSpeed;
	}

	public void setShootSpeed(int shootSpeed) {
		this.shootSpeed = shootSpeed;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public void setDoubleShot(boolean isDoubleShot) {
		this.isDoubleShot = isDoubleShot;
	}

	public boolean isDoubleShot() { return isDoubleShot; }

	public void move(int x, int y) {
		setX( getX() + (x * moveSpeed) );
		setY( getY() + (y * moveSpeed));
	}

}