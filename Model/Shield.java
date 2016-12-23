package Model;

public class Shield extends PowerUp{
	
	//private static final int ID = 27;
	public Shield(int x, int y) {
		super(x,y);
		this.id = 27;
	}
	@Override
	public void affect(PlayerTank x) {
		x.shield = 3;
	}
	
}