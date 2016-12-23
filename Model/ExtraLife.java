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

}