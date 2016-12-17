package Model;


public class Bullet extends GameBody implements Destroyable{

	private int moveSpeed;
	private static final int ID = 2;

	public Bullet( int x, int y, int moveSpeed){
		super(x, y);
		this.moveSpeed = moveSpeed;
	}

	public int getMoveSpeed() { return moveSpeed; }
	public int getId() { return ID; }

	public void move() {
		this.setX( this.getX() + this.getMoveSpeed() );
		this.setY( this.getY() + this.getMoveSpeed() );
	}

	@Override
	public boolean getDestroyed(GameEngine engine) {
		engine.destroyGameBody( this);
		return true;
	}

}