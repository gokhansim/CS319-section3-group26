package Model;

public class SacredObject extends GameBody implements Destroyable{

	private boolean isDestroyed;
	
	public SacredObject(int x, int y){
		super(x, y);
		this.isDestroyed = false;
	}

	public boolean getIsDestroyed() { return isDestroyed; }
	public void setIsDestroyed(boolean bool) { isDestroyed = bool; }

	@Override
	public boolean getDestroyed(GameEngine engine) {
		engine.destroyGameBody( this);
		this.setIsDestroyed(true);
		return this.getIsDestroyed();
	}
	
}
