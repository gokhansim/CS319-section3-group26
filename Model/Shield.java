package Model;

public class Shield extends PowerUp{
	
	//private static final int ID = 27;
	public Shield(int x, int y) {
		super(x,y);
		this.id = 27;
	}
	
	@Override
	public boolean getDestroyed(GameEngine engine) {
		engine.getPlayerTank().shield = 1;
		engine.destroyGameBody(this);
		return true;
	}
	
}