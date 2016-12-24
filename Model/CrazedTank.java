package Model;

public class CrazedTank extends EnemyTank {

	public CrazedTank(int x, int y) {
		super(x, y);
		this.setMoveSpeed(1);
		this.id = 16;
		this.hitsToKill = 3;
		this.scoreGiven = 20;
	}

}
