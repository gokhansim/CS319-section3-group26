package Model;


public class Bullet extends GameBody implements Destroyable{

	private int moveSpeed;

	public Bullet( int x, int y, int moveSpeed){
		super(x, y);
		this.moveSpeed = moveSpeed;
	}

	public int getMoveSpeed() { return moveSpeed; }

	public void move() {
		this.setX( this.getX() + this.getMoveSpeed() );
		this.setY( this.getY() + this.getMoveSpeed() );
	}

	@Override
	public void getDestroyed(GameEngine engine) {
		engine.destroyGameBody( this);
	}

}