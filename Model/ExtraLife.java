package Model;

public class ExtraLife extends PowerUp{
	
	public ExtraLife(int x, int y) {
		super(x,y);
	}
	
	public void affect(PlayerTank x) {
		if (x.getCurrentLives() < 3) {
			x.increaseLife();
		}
	}
}