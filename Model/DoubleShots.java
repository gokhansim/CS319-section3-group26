package Model;

public class DoubleShots extends PowerUp {
	//private static final int ID = 25;
	public DoubleShots(int x, int y) {
		super(x,y);
		this.id = 25;
	}
	
	public void affect(PlayerTank x) {
		x.isDoubleShot=true;
	}
	
}