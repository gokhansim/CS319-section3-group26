package Model;

import Controller.Game;

public class GameEngine {

	private static final int MAP_SIZE = 10;

	private GameBody[][] map;
	private int[][] intMap;
	private CollisionManager colMngr;
	private int score;

	public GameEngine(){
		this.map = new GameBody[MAP_SIZE][MAP_SIZE];
		this.intMap = new int[MAP_SIZE][MAP_SIZE];

		for( int i = 0; i < MAP_SIZE; i++){
			for( int j = 0; j < MAP_SIZE; j++){
				map[i][j] = null;
				intMap[i][j] = -1;
			}
		}
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
			if( aBody instanceof PlayerTank){
				intMap[x][y] = ((PlayerTank)aBody).getId();
			}
			else if( aBody instanceof EnemyTank){
				intMap[x][y] = ((EnemyTank)aBody).getId();
			}
			else if( aBody instanceof BrickWall){
				intMap[x][y] = ((BrickWall)aBody).getId();
			}
			else if( aBody instanceof IronWall){
				intMap[x][y] = ((IronWall)aBody).getId();
			}
			else if( aBody instanceof SteelWall){
				intMap[x][y] = ((SteelWall)aBody).getId();
			}
			else if( aBody instanceof SacredObject){
				intMap[x][y] = ((SacredObject)aBody).getId();
			}

		}
		else if( map[x][y] != null ){
			if( colMngr.checkCollision( aBody, map[x][y], this) ){
				map[x][y] = aBody;
			}
		}
	}

	public void destroyGameBody(GameBody body) {

		int xCoor = body.getX();
		int yCoor = body.getY();
		if( map[xCoor][yCoor] != null ) {
			map[xCoor][yCoor] = null;
		}
	}

	public void placeAllBodies(int level){
		if( level == 1){
			PlayerTank playerTank = new PlayerTank(4,7);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );
			EnemyTank enemyTank = new EnemyTank(0,0, 3, 10 );
			this.createGameBody(enemyTank, enemyTank.getX(), enemyTank.getY() );
			EnemyTank enemyTank2 = new EnemyTank(9,0, 3, 10 );
			this.createGameBody(enemyTank2, enemyTank2.getX(), enemyTank2.getY() );

			IronWall ironWall = new IronWall(3,8);
			this.createGameBody(ironWall, ironWall.getX(), ironWall.getY());
			this.createGameBody(new IronWall(5,8), 5, 8 );

			this.createGameBody(new BrickWall(1,3), 1, 3 );
			this.createGameBody(new BrickWall(2,2), 2, 2 );
			this.createGameBody(new BrickWall(3,1), 3, 1 );

			this.createGameBody(new BrickWall(6,1), 6, 1 );
			this.createGameBody(new BrickWall(7,2), 7, 2 );
			this.createGameBody(new BrickWall(8,3), 8, 3 );

			this.createGameBody(new BrickWall(3,5), 3, 5 );
			this.createGameBody(new SteelWall(4,5), 4, 5 );
			this.createGameBody(new SteelWall(5,5), 5, 5 );
			this.createGameBody(new BrickWall(6,5), 6, 5 );

			this.createGameBody(new BrickWall(3,9), 3, 9 );
			this.createGameBody(new BrickWall(4,8), 4, 8 );
			this.createGameBody(new SacredObject(4,9), 4, 9 );
			this.createGameBody(new BrickWall(5,9), 5, 9 );
			// this.createGameBody( new Bullet(1,1, 1), 1, 1 );
		}
	}

	public GameBody[][] getMap() { return map; }
	public GameBody getMapItem(int x, int y) { return map[x][y]; }
	public int getMapSize() { return MAP_SIZE; }
	public int[][] getIntMap() { return intMap; }


	// just for testing. To be deleted later
	public void printMap(){
		for( int i = 0; i < this.getMapSize(); i++){
			for( int j = 0; j < this.getMapSize(); j++){
				if( map[i][j] != null) {
					System.out.println("at (" + i + ", " + j + ")  ->  " + this.getMapItem(i, j));
				}
			}
		}
	}
	// just for testing. To be deleted later
	public void printIntMap(){
		System.out.println("- printIntMap() -");
		for( int i = 0; i < this.getMapSize(); i++){
			for( int j = 0; j < this.getMapSize(); j++){
				if( intMap[i][j] != -1 ) {
					System.out.println("at (" + i + ", " + j + ")  ->  " + this.intMap[i][j] );
				}
			}
		}
	}

	public void updateMap() {
		
	}

	/*
	public static void main(String[] args) {
		//PLAYER TANK AND ENEMY TANK TRIALS
		/*
		PlayerTank playerTank = new PlayerTank(3,3);
		engine.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

		System.out.println( engine.getMapItem(3,3));
		System.out.println(engine.getMapItem( playerTank.getX(), playerTank.getY()) );
		playerTank.move();
		System.out.println(playerTank.getX());

		System.out.println( engine.getMapItem(3,3));
		System.out.println(engine.getMapItem( playerTank.getX(), playerTank.getY()) );

		EnemyTank enemyTank = new EnemyTank(3, 5, 3, 5);
		engine.createGameBody(enemyTank, enemyTank.getX(), enemyTank.getY() );
		*/

		/*
		for( int i = 0; i < engine.getMapSize(); i++){
			for( int j = 0; j < engine.getMapSize(); j++){
				System.out.println(engine.getMapItem(i, j));
				count++;
			}
		}

	}
	*/
}