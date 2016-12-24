package Model;

public class CrazedTank extends EnemyTank {

	public CrazedTank(int x, int y, int hitsToKill, int scoreGiven) {
		super(x, y, hitsToKill, scoreGiven);
		this.setMoveSpeed(1);
		this.id = 16;
	}

}
