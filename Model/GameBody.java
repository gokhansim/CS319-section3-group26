package Model;

public class GameBody {
	private int x;
	private int y;
	protected int id;

	public GameBody( int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getID() {
		return this.id;
	}
	public void setID(int id1) {
		this.id = id1;
	}
	
	public int getX(){
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX( int x){
		if( x < 10 && x > -1) { // mapSize in GameEngine is 10, thus 10.
			this.x = x;
		}
	}

	public void setY( int y) {
		if( y < 10 && y > -1) {
			this.y = y;
		}
	}

}
