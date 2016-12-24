package Model;


public class Bullet extends GameBody implements Destroyable{

	private int moveSpeed;
	private int direction;
	private int shooter;

	public Bullet( int x, int y, int moveSpeed, int direction, int shooter){
		super(x, y);
		this.moveSpeed = moveSpeed;
		this.direction = direction;
		this.shooter = shooter;  // if shooter = 1 -> bullet from the playerTank.
		if( direction == 0){
			this.id = 20;
		}
		else if( direction == 1){
			this.id = 21;
		}
		else if( direction == 2){
			this.id = 22;
		}
		else if( direction == 3){
			this.id = 23;
		}
	}

	public int getShooter() { return this.shooter; }
	public int getMoveSpeed() { return moveSpeed; }
	public int getDirection() { return direction; }

	public void move(int x, int y) {
		this.setX( this.getX() + (this.getMoveSpeed() * x) );
		this.setY( this.getY() + (this.getMoveSpeed() * y) );
	}

	@Override
	public boolean getDestroyed(GameEngine engine) {
		engine.destroyGameBody( this);
		return true;
	}

}