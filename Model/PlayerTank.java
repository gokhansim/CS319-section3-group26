package Model;

public class PlayerTank extends Tank implements Destroyable{

	private int currentLives;
	private int shield;
	private boolean isUltimate;

	public PlayerTank(int x, int y){
		super(x, y);
		this.currentLives = 3;
		this.shield = 0;
		this.isUltimate = false;
	}

	public void getPowerUp( int type) {
		// type1 -> Shield
		if( type == 1){
			this.shield = 3;
		}
		// type2 -> DoubleShots
		else if( type == 2){
			isDoubleShot = true;
		}
		// type3 -> ExtraLife
		else if( type == 3){
			this.increaseLife();
		}
		// type3 -> UltimateProtection
		else if( type == 4){
			isUltimate = true;
		}
	}

	public void endPowerUp(){
		isDoubleShot = false;
		this.shield = 0;
		isUltimate = false;
	}

	public void increaseLife() {
		currentLives++;
	}

	public void decreaseLife() {
		if( currentLives > 0) {
			currentLives--;
		}
	}

	public int getShield(){ return this.shield; }
	public void decreaseShield() { this.shield--; }
	public int getCurrentLives(){ return currentLives; }


	public void getDestroyed( GameEngine engine){
		if( this.getShield() == 0){
			if( this.getCurrentLives() == 0){
				engine.destroyGameBody( this);
			}
		}
		else{
			this.decreaseShield();
		}
	}


}