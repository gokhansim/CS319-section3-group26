package Model;

public class IronWall extends Wall implements Destroyable{

	private int hitsToDestroy;
	private int type;
	private static final int SCORE = 25;

	public IronWall(int x, int y){
		super(x, y);
		this.hitsToDestroy = 2;
		this.type = 2;
	}
	public int getType(){
		return type;
	}
	public int getScore(){
		return SCORE;
	}
	public int getHitsToDestroy() { return hitsToDestroy; }
	public void decreaseHitsToDestroy() { --hitsToDestroy; }

	@Override
	public void getDestroyed(GameEngine engine) {
		if( this.getHitsToDestroy() == 0 ){
			engine.destroyGameBody( this);
			engine.addScore( this.getScore() );
		}
		else{ // in every collision, getDestroyed method will be invoked.
			this.decreaseHitsToDestroy();
		}
	}
}
