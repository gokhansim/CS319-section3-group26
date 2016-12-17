package Model;

public class EnemyTank extends Tank implements Destroyable{

	private int hitsToKill;
	private int scoreGiven;

	public EnemyTank( int x, int y, int hitsToKill, int scoreGiven){
		super(x, y);
		this.hitsToKill = hitsToKill;
		this.scoreGiven = scoreGiven;
	};

	public int getHistToKill() { return hitsToKill; }
	public void decreaseHitsToKill() { hitsToKill--; }
	public int getScoreGiven() { return scoreGiven; }

	@Override
	public boolean getDestroyed(GameEngine engine) {
		if( this.getHistToKill() == 0){
			engine.destroyGameBody( this);
			engine.addScore( this.getScoreGiven() );
			return true;
		}
		else{
			this.decreaseHitsToKill();
			return false;
		}
	}
}