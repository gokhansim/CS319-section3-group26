package Model;

public class Shield extends PowerUp{
	
	public Shield(int x, int y) {
		super(x,y);
	}
	@Override
	public void affect(PlayerTank x) {
		x.shield = 3;
	}
}