package Model;

public class PlayerTank extends Tank implements Destroyable{

	private int currentLives;
	protected int shield;
	private boolean isUltimate;
	//private static final int ID = 0;

	public PlayerTank(int x, int y){
		super(x, y);
		this.currentLives = 3;
		this.shield = 0;
		this.setShootSpeed(1);
		this.isUltimate = false;
		this.id = 0;
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