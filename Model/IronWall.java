package Model;

public class IronWall extends Wall{
	
	private int type;
	private int score;
	public IronWall(){
		type = 2;
		score = 30;
	}
	public int getTypeIron(){
		return type;
	}
	public int getScoreIron(){
		return score;
	}
}
