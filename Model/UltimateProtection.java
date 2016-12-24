package Model;

public class UltimateProtection extends PowerUp {
	public UltimateProtection(int x, int y) {
		super(x,y);
		this.id = 26;
	}

	@Override
	public boolean getDestroyed(GameEngine engine) {
		engine.destroyGameBody(this);
		return false;
	}
	
}