package Model;

public class PlayerTank extends Tank implements Destroyable{

	private int currentLives;
	protected int shield;
	private boolean isUltimate;
	private static final int ID = 0;

	public PlayerTank(int x, int y){
		super(x, y);
		this.currentLives = 3;
		this.shield = 0;
		this.setShootSpeed(1);
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
	public void decreaseShield() {
		if (shield > 0) {
			this.shield--;
		}
	}
	public int getCurrentLives(){ return currentLives; }
	public int getId() { return ID; }

	public boolean getDestroyed( GameEngine engine){
		if( this.getShield() == 0){
			if( this.getCurrentLives() == 0){
				engine.destroyGameBody( this);
				return true;
			}
			else{
				this.decreaseLife();
				return false;
			}
		}
		else{
			this.decreaseShield();
			return false;
		}
	}


}