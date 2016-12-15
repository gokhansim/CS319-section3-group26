package Model;

public class Wall extends GameBody{
	
	private int xPosition;
	private int yPosition;
	private int type;
	private int totalScoreOfWalls;
	private BrickWall wall1;
	private IronWall wall2;
	private SteelWall wall3;
	
	
	public Wall(){
		x = xPosition;
		y = yPosition;
		totalScoreOfWalls = 0;
	}
	public int getIndestructible(){
		totalScoreOfWalls += 0;
		return totalScoreOfWalls;
	}
	public int getTotalScore(){
		if(type == wall1.getTypeBrick()){
			totalScoreOfWalls += wall1.getScoreBrick();
		}
		else if(type == wall2.getTypeIron()){
			totalScoreOfWalls += wall2.getScoreIron();
		}
		else{
			totalScoreOfWalls += wall3.getScoreSteel();
		}
		return totalScoreOfWalls;
	}
}
