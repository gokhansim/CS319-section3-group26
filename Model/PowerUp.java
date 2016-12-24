package Model;

public abstract class PowerUp extends GameBody implements Destroyable {
	private final int TIME_TO_EXPIRE = 10;
	
	public PowerUp(int x, int y) {
		super(x,y);
	}
	
	public void getPicked() {
		
	}
	
	public void affect(PlayerTank x) {
		
	}
	
	public void appear() {
		
	}
	
	public void expire() {
		
	}
}

