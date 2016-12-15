package Model;

public class BrickWall extends Wall{
	
	private int type;
	private int score;
	
	public BrickWall(){
		type = 1;
		score = 10;
	}
	public int getTypeBrick(){
		return type;
	}
	public int getScoreBrick(){
		return score;
	}
}
