package Model;

public class SacredObject extends GameBody implements Destroyable{

	private boolean isDestroyed;
	private static final int ID = 6;
	
	public SacredObject(int x, int y){
		super(x, y);
		this.isDestroyed = false;
	}

	public boolean getIsDestroyed() { return isDestroyed; }
	public void setIsDestroyed(boolean bool) { isDestroyed = bool; }
	public int getId() { return ID; }

	@Override
	public boolean getDestroyed(GameEngine engine) {
		engine.destroyGameBody( this);
		this.setIsDestroyed(true);
		return this.getIsDestroyed();
	}
	
}
