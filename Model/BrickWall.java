package Model;

public class BrickWall extends Wall implements Destroyable{
	
	private int type;
	private static final int SCORE = 10;
	private boolean isDestructible;
	
	public BrickWall(int x, int y){
		super(x, y);
		type = 1;
		this.isDestructible = true;
	}
	public int getType(){
		return type;
	}
	public int getScore(){
		return SCORE;
	}

	public void getIndestructible() { isDestructible = false; }

	@Override
	public void getDestroyed(GameEngine engine) {
		if( this.isDestructible ){
			engine.destroyGameBody( this);
			engine.addScore( this.getScore() );
		}
	}


}
