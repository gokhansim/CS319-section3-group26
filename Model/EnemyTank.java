package Model;

public class EnemyTank extends Tank implements Destroyable{

	protected int hitsToKill;
	protected int scoreGiven;

	public EnemyTank( int x, int y){
		super(x, y);
		this.hitsToKill = 3;
		this.scoreGiven = 10;
		this.id = 13;
		this.setShootSpeed(1);
	};

	public int getHistToKill() { return hitsToKill; }
	public void decreaseHitsToKill() { hitsToKill--; }
	public int getScoreGiven() { return scoreGiven; }



	@Override
	public boolean getDestroyed(GameEngine engine) {
		if( this.getHistToKill() == 0){
			engine.destroyGameBody( this);
			engine.addScore( this.getScoreGiven() );
			engine.decreaseEnemyTanksLeft();
			return true;
		}
		else{
			this.decreaseHitsToKill();
			return false;
		}
	}
	
	public void moveTank(int x, int y) {

		this.setX(this.getX() + x);
		this.setY(this.getY() + y);
		/*
		int direction = 1 + (int) Math.random() * 4;
		if ( direction == 1) {
			this.move(1, 0);
		}
		else if ( direction == 2) {
			this.move(-1, 0);
		}
		else if ( direction == 3) {
			this.move(0, 1);
		}
		else if ( direction == 4) {
			this.move(0, -1);
		}
		*/
		
	}
	
	
}
