package Model;

public class EnemyTank extends Tank implements Destroyable{

	private int hitsToKill;
	private int scoreGiven;
	private static final int ID = 1;

	public EnemyTank( int x, int y, int hitsToKill, int scoreGiven){
		super(x, y);
		this.hitsToKill = hitsToKill;
		this.scoreGiven = scoreGiven;
	};

	public int getHistToKill() { return hitsToKill; }
	public void decreaseHitsToKill() { hitsToKill--; }
	public int getScoreGiven() { return scoreGiven; }
	public int getId() { return ID; }

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
	
	public void moveTank() {
		int direction = 1 + (int) Math.random() * 4;
		if ( direction == 1) {
			this.move(1, 0);
		}
		else if ( direction == 2) {
			this.move(-1, 0);
		}
		else if ( direction == 2) {
			this.move(0, 1);
		}
		else if ( direction == 2) {
			this.move(0, -1);
		}
		
	}
}