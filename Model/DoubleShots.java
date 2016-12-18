package Model;

public class DoubleShots extends PowerUp {
	
	public DoubleShots(int x, int y) {
		super(x,y);
	}
	
	public void affect(PlayerTank x) {
		x.isDoubleShot=true;
	}
}