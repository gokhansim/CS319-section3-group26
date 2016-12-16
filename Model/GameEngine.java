package Model;

import Controller.Game;

public class GameEngine {

	private static final int MAP_SIZE = 40;

	private GameBody[][] map;
	private CollisionManager colMngr;
	private int score;

	public GameEngine(){
		this.map = new GameBody[MAP_SIZE][MAP_SIZE];
		this.score = 0;
		colMngr = new CollisionManager();
	}

	public void addScore( int scoreGiven){ score = score + scoreGiven; }
	public int getScore() { return score; }

	// places new GameBody in the map.
	public void createGameBody(GameBody body, int x, int y) {
		GameBody aBody = body;
		if( map[x][y] == null ) {
			map[x][y] = aBody;
		}
		else if( map[x][y] != null ){
			if( checkCollision(body, map[x][y]) ){
				map[x][y] = aBody;
			}
		}
	}

	public void destroyGameBody(GameBody body) {

		int xCoor = body.getX();
		int yCoor = body.getY();
		if( map[xCoor][yCoor] != null ) {
			if (body instanceof EnemyTank) {
				map[xCoor][yCoor] = null;
			}
		}
	}

	public static GameBody[][] getMap() { return map; }
	public static GameBody getMapItem(int x, int y) { return map[x][y]; }

	public void updateMap() {

	}

}