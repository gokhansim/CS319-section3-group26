package Model;

public class SteelWall extends Wall{
	
	private int type;
	private int score;
	
	public SteelWall(){
		type = 3;
		score = 0;
	}
	public int getScoreSteel(){
		return score;
	}
	public int getTypeSteel(){
		return type;
	}
}
