package Model;

public class ExtraLife extends PowerUp{
	
	//private static final int ID = 24;
	public ExtraLife(int x, int y) {
		super(x,y);
		this.id = 24;
	}
	
	public void affect(PlayerTank x) {
		if (x.getCurrentLives() < 3) {
			x.increaseLife();
		}
	}

	@Override
	public boolean getDestroyed(GameEngine engine) {
		if (engine.getPlayerTank().getCurrentLives() < 3) 
			engine.getPlayerTank().increaseLife();
		engine.destroyGameBody(this);
		return true;
	}

}