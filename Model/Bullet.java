package Model;


public class Bullet extends GameBody implements Destroyable{

	private int moveSpeed;
	private int direction;
	private int id;

	public Bullet( int x, int y, int moveSpeed, int direction){
		super(x, y);
		this.moveSpeed = moveSpeed;
		this.direction = direction;
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

	public int getMoveSpeed() { return moveSpeed; }
	public int getId() { return id; }
	public int getDirection() { return direction; }

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