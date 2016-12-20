package Model;

import Controller.Game;

import java.util.LinkedList;

public class GameEngine {

	private static final int MAP_SIZE = 100;

	private GameBody[][] map;
	private int[][] intMap;
	private CollisionManager colMngr;
	private int score;
	protected boolean isGameOver;
	PlayerTank playerTank;
	EnemyTank enemyTank;
	private int enemyTanksLeft;
	private LinkedList<Bullet> bulletList = new LinkedList<Bullet>();

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
		this.isGameOver = false;
		colMngr = new CollisionManager();
	}

	// BULLET
	public void addBullet(Bullet bullet){
		bulletList.add(bullet);
	}
	public void removeBullet(Bullet bullet){
		bulletList.remove(bullet);
	}
	public void moveBullet( Bullet bullet) {
		Bullet tempBullet;
		for( int i = 0; i < bulletList.size(); i++){
			tempBullet = bulletList.get(i);
			if( tempBullet.getId() == 23){
				this.createGameBody( tempBullet, bullet.getX() - bullet.getMoveSpeed(), bullet.getY());
			}
			else if( tempBullet.getId() == 22){
				this.createGameBody( tempBullet, bullet.getX() , bullet.getY() + bullet.getMoveSpeed());
			}
			if( tempBullet.getId() == 21){
				this.createGameBody( tempBullet, bullet.getX() + bullet.getMoveSpeed(), bullet.getY());
			}
			if( tempBullet.getId() == 20){
				this.createGameBody( tempBullet, bullet.getX(), bullet.getY() - bullet.getMoveSpeed());
			}
		}

	}
	//	----

	public void addScore( int scoreGiven){ score = score + scoreGiven; }
	public int getScore() { return score; }
	public boolean getIsGameOver() { return isGameOver; }

	public int getEnemyTanksLeft(){ return enemyTanksLeft; }
	public void setEnemyTanksLeft( int enemyTanksLeft){ this.enemyTanksLeft = enemyTanksLeft;}
	public void decreaseEnemyTanksLeft() { this.enemyTanksLeft--;}

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
			else if( aBody instanceof Bullet){
				intMap[x][y] = ((Bullet)aBody).getId();
				bulletList.add((Bullet)aBody);
			}

		}
		else if( map[x][y] != null ){
			if( colMngr.checkCollision( aBody, map[x][y], this) ){
					this.destroyGameBody(aBody);
					bulletList.remove(aBody);
			}
		}
	}

	public void destroyGameBody(GameBody body) {

		int xCoor = body.getX();
		int yCoor = body.getY();
		if( map[xCoor][yCoor] != null ) {
			map[xCoor][yCoor] = null;
			intMap[xCoor][yCoor] = -1;
		}
	}

	public void placeAllBodies(int level){
		if( level == 1){
			this.cleanMap();
			this.setEnemyTanksLeft(2);
			playerTank = new PlayerTank(4,7);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			enemyTank = new EnemyTank(0,0, 3, 10 );
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

		// this.printIntMap();


		else if(level == 2){
			this.cleanMap();
			this.setEnemyTanksLeft(3);
			playerTank = new PlayerTank(9,9);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			EnemyTank enemyTank = new EnemyTank(0,0, 3, 10 );
			this.createGameBody(enemyTank, enemyTank.getX(), enemyTank.getY() );
			EnemyTank enemyTank2 = new EnemyTank(9,0, 3, 10 );//will be change to crazed 
			this.createGameBody(enemyTank2, enemyTank2.getX(), enemyTank2.getY() );
			EnemyTank enemyTank3 = new EnemyTank(0,9, 3, 10 ); //this will be changed to crazed
			this.createGameBody(enemyTank3, enemyTank3.getX(), enemyTank3.getY() );

			this.createGameBody(new BrickWall(2, 0), 2, 0);
			this.createGameBody(new BrickWall(1, 1), 1, 1);
			this.createGameBody(new BrickWall(7, 0), 7, 0);
			this.createGameBody(new BrickWall(8,1), 8, 1);
			this.createGameBody(new BrickWall(0,2), 0, 2);
			this.createGameBody(new BrickWall(9, 2), 9, 2);
			this.createGameBody(new BrickWall(1, 3), 1, 3);
			this.createGameBody(new BrickWall(4, 3), 4, 3);
			this.createGameBody(new BrickWall(6, 3), 6, 3);
			this.createGameBody(new BrickWall(8, 3), 8, 3);
			this.createGameBody(new BrickWall(1, 4), 1, 4);
			this.createGameBody(new BrickWall(8, 4), 8, 4);
			this.createGameBody(new BrickWall(1, 5), 1, 5);
			this.createGameBody(new BrickWall(8, 5), 8, 5);
			this.createGameBody(new BrickWall(1, 4), 1, 4);
			this.createGameBody(new BrickWall(4, 5), 4, 5);
			this.createGameBody(new BrickWall(6, 5), 6, 5);
			this.createGameBody(new BrickWall(0, 6), 0, 6);
			this.createGameBody(new BrickWall(9, 6), 9, 6);
			this.createGameBody(new BrickWall(1, 7), 1, 7);
			this.createGameBody(new BrickWall(8, 7), 8, 7);
			this.createGameBody(new BrickWall(2, 8), 2, 8);
			this.createGameBody(new BrickWall(7, 8), 7, 8);
			this.createGameBody(new BrickWall(3, 9), 3, 9);
			this.createGameBody(new BrickWall(6, 9), 6, 9);

			this.createGameBody(new IronWall(5, 3), 5, 3);
			this.createGameBody(new IronWall(4, 4), 4, 4);
			this.createGameBody(new IronWall(6, 4), 6, 4);
			this.createGameBody(new IronWall(5, 5), 5, 5);

			this.createGameBody(new SacredObject(5, 4), 5, 4);

		}

		else if(level == 3){
			this.cleanMap();
			this.setEnemyTanksLeft(4);
			playerTank = new PlayerTank(4,8);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			EnemyTank enemyTank = new EnemyTank(0,0, 3, 10 );
			this.createGameBody(enemyTank, enemyTank.getX(), enemyTank.getY() );
			EnemyTank enemyTank2 = new EnemyTank(9,0, 3, 10 );//will be change to crazed 
			this.createGameBody(enemyTank2, enemyTank2.getX(), enemyTank2.getY() );
			EnemyTank enemyTank3 = new EnemyTank(0,9, 3, 10 ); //this will be changed to crazed
			this.createGameBody(enemyTank3, enemyTank3.getX(), enemyTank3.getY() );
			EnemyTank enemyTank4 = new EnemyTank(9,9, 3, 10 ); 					
			this.createGameBody(enemyTank4, enemyTank4.getX(), enemyTank4.getY() );



			this.createGameBody(new BrickWall(1, 1), 1, 1);
			this.createGameBody(new BrickWall(3, 1), 3, 1);
			this.createGameBody(new BrickWall(7, 1), 7, 1);
			this.createGameBody(new BrickWall(8, 2), 8, 2);
			this.createGameBody(new BrickWall(1, 3), 1, 3);
			this.createGameBody(new BrickWall(8, 4), 8, 4);
			this.createGameBody(new BrickWall(1, 5), 1, 5);
			this.createGameBody(new BrickWall(8, 6), 8, 6);
			this.createGameBody(new BrickWall(1, 7), 1, 7);
			this.createGameBody(new BrickWall(3, 7), 3, 7);
			this.createGameBody(new BrickWall(5, 7), 5, 7);
			this.createGameBody(new BrickWall(7, 7), 7, 7);

			this.createGameBody(new IronWall(2, 1), 2, 1);
			this.createGameBody(new IronWall(4, 1), 4, 1);
			this.createGameBody(new IronWall(6, 1), 6, 1);
			this.createGameBody(new IronWall(8, 1), 8, 1);
			this.createGameBody(new IronWall(1, 2), 1, 2);
			this.createGameBody(new IronWall(3, 3), 3, 3);
			this.createGameBody(new IronWall(4, 3), 4, 3);
			this.createGameBody(new IronWall(5, 3), 5, 3);
			this.createGameBody(new IronWall(8, 3), 8, 3);
			this.createGameBody(new IronWall(1, 4), 1, 4);
			this.createGameBody(new IronWall(3, 4), 3, 4);
			this.createGameBody(new IronWall(5, 4), 5, 4);
			this.createGameBody(new IronWall(3, 5), 3, 5);
			this.createGameBody(new IronWall(4, 5), 4, 5);
			this.createGameBody(new IronWall(5, 5), 5, 5);
			this.createGameBody(new IronWall(8, 5), 8, 5);
			this.createGameBody(new IronWall(1, 6), 1, 6);
			this.createGameBody(new IronWall(2, 7), 2, 7);
			this.createGameBody(new IronWall(6, 7), 6, 7);
			this.createGameBody(new IronWall(8, 7), 8, 7);

			this.createGameBody(new SteelWall(0,4), 0, 4);
			this.createGameBody(new SteelWall(9, 4), 9, 4);

			this.createGameBody(new SacredObject(4, 4), 4, 4);

		}
		
		else if(level == 4){
			this.cleanMap();
			this.setEnemyTanksLeft(6);
			playerTank = new PlayerTank(4, 4);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			EnemyTank enemyTank = new EnemyTank(0, 0, 3, 10 );
			this.createGameBody(enemyTank, enemyTank.getX(), enemyTank.getY() );
			EnemyTank enemyTank2 = new EnemyTank(9, 0, 3, 10 );
			this.createGameBody(enemyTank2, enemyTank2.getX(), enemyTank2.getY() );
			EnemyTank enemyTank3 = new EnemyTank(0, 6, 3, 10 ); 
			this.createGameBody(enemyTank3, enemyTank3.getX(), enemyTank3.getY() );
			EnemyTank enemyTank4 = new EnemyTank(9, 6, 3, 10 ); 
			this.createGameBody(enemyTank4, enemyTank4.getX(), enemyTank4.getY() );
			EnemyTank enemyTank5 = new EnemyTank(2, 2, 3, 10 ); 
			this.createGameBody(enemyTank5, enemyTank5.getX(), enemyTank5.getY() );
			EnemyTank enemyTank6 = new EnemyTank(6, 2, 3, 10 ); 
			this.createGameBody(enemyTank6, enemyTank6.getX(), enemyTank6.getY() );

			this.createGameBody(new SteelWall(1, 1), 1, 1);
			this.createGameBody(new SteelWall(3, 1), 3, 1);
			this.createGameBody(new SteelWall(5, 1), 5, 1);
			this.createGameBody(new SteelWall(7, 1), 7, 1);
			this.createGameBody(new SteelWall(1, 3), 1, 3);
			this.createGameBody(new SteelWall(3, 3), 3, 3);
			this.createGameBody(new SteelWall(5, 3), 5, 3);
			this.createGameBody(new SteelWall(7, 3), 7, 3);
			this.createGameBody(new SteelWall(1, 5), 1, 5);
			this.createGameBody(new SteelWall(3, 5), 3, 5);
			this.createGameBody(new SteelWall(5, 5), 5, 5);
			this.createGameBody(new SteelWall(7, 5), 7, 5);
			this.createGameBody(new SteelWall(1, 7), 1, 7);
			this.createGameBody(new SteelWall(3, 7), 3, 7);
			this.createGameBody(new SteelWall(5, 7), 5, 7);
			this.createGameBody(new SteelWall(7, 7), 7, 7);

			this.createGameBody(new BrickWall(2, 0), 2, 0);
			this.createGameBody(new BrickWall(4, 0), 4, 0);
			this.createGameBody(new BrickWall(6, 0), 6, 0);
			this.createGameBody(new BrickWall(0, 2), 0, 2);
			this.createGameBody(new BrickWall(9,2), 9,2);
			this.createGameBody(new BrickWall(0, 4), 0, 4);
			this.createGameBody(new BrickWall(9, 4), 9, 4);
			this.createGameBody(new BrickWall(4, 6), 4, 6);
			this.createGameBody(new BrickWall(2, 9), 2, 9);
			this.createGameBody(new BrickWall(6, 9), 6, 9);


			this.createGameBody(new IronWall(3,8), 3, 8);
			this.createGameBody(new IronWall(4,8), 4, 8);
			this.createGameBody(new IronWall(5,8), 5, 8);
			this.createGameBody(new IronWall(3,9), 4, 9);
			this.createGameBody(new IronWall(5,9), 5, 9);

			this.createGameBody(new SacredObject(4,7), 4, 7);


		}

		else if(level == 5){
			this.cleanMap();
			this.setEnemyTanksLeft(6);
			playerTank = new PlayerTank(4,7);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			EnemyTank enemyTank = new EnemyTank(0,0, 3, 10 );
			this.createGameBody(enemyTank, enemyTank.getX(), enemyTank.getY() );
			EnemyTank enemyTank2 = new EnemyTank(9,0, 3, 10 );//will be change to crazed 
			this.createGameBody(enemyTank2, enemyTank2.getX(), enemyTank2.getY() );
			EnemyTank enemyTank3 = new EnemyTank(0,9, 3, 10 ); //this will be changed to crazed
			this.createGameBody(enemyTank3, enemyTank3.getX(), enemyTank3.getY() );
			EnemyTank enemyTank4 = new EnemyTank(9,9, 3, 10 ); 					
			this.createGameBody(enemyTank4, enemyTank4.getX(), enemyTank4.getY() );
			EnemyTank enemyTank5 = new EnemyTank(2,2, 3, 10 ); //this will be changed to crazed
			this.createGameBody(enemyTank5, enemyTank5.getX(), enemyTank5.getY() );
			EnemyTank enemyTank6 = new EnemyTank(7,2, 3, 10 ); 	
			this.createGameBody(enemyTank6, enemyTank6.getX(), enemyTank6.getY() );

			this.createGameBody(new SteelWall(1,1), 1, 1);
			this.createGameBody(new SteelWall(8, 1), 8, 1);
			this.createGameBody(new SteelWall(1,8), 1, 8);
			this.createGameBody(new SteelWall(8, 8), 8, 8);

			this.createGameBody(new IronWall(2, 1), 2, 1);
			this.createGameBody(new IronWall(3, 1), 3, 1);
			this.createGameBody(new IronWall(5, 1), 5, 1);
			this.createGameBody(new IronWall(6, 1), 6, 1);
			this.createGameBody(new IronWall(7, 1), 7, 1);
			this.createGameBody(new IronWall(1, 2), 1, 2);
			this.createGameBody(new IronWall(1, 3), 1, 3);
			this.createGameBody(new IronWall(1, 2), 1, 2);
			this.createGameBody(new IronWall(1, 4), 1, 4);
			this.createGameBody(new IronWall(1, 6), 1, 6);
			this.createGameBody(new IronWall(1, 7), 1, 7);
			this.createGameBody(new IronWall(4, 2), 4, 2);
			this.createGameBody(new IronWall(8, 2), 8, 2);
			this.createGameBody(new IronWall(4, 3), 4, 3);
			this.createGameBody(new IronWall(8, 3), 8, 3);
			this.createGameBody(new IronWall(3, 4), 3, 4);
			this.createGameBody(new IronWall(4, 4), 4, 4);
			this.createGameBody(new IronWall(5, 4), 5, 4);
			this.createGameBody(new IronWall(8, 4), 8, 4);
			this.createGameBody(new IronWall(2, 5), 2, 5);
			this.createGameBody(new IronWall(3, 5), 3, 5);
			this.createGameBody(new IronWall(5, 5), 5, 5);
			this.createGameBody(new IronWall(6, 5), 6, 5);
			this.createGameBody(new IronWall(7, 5), 7, 5);
			this.createGameBody(new IronWall(3, 6), 3, 6);
			this.createGameBody(new IronWall(4, 6), 4, 6);
			this.createGameBody(new IronWall(5, 6), 5, 6);
			this.createGameBody(new IronWall(8, 6), 8, 6);
			this.createGameBody(new IronWall(8, 7), 8, 7 );
			this.createGameBody(new IronWall(2, 8), 2, 8);
			this.createGameBody(new IronWall(3, 8), 3, 8);
			this.createGameBody(new IronWall(5, 8), 5, 8);
			this.createGameBody(new IronWall(6, 8), 6, 8);
			this.createGameBody(new IronWall(7, 8), 7, 8);

			this.createGameBody(new BrickWall(4, 1), 4, 1);
			this.createGameBody(new BrickWall(1, 5), 1, 5);
			this.createGameBody(new BrickWall(8, 5), 8, 5);
			this.createGameBody(new BrickWall(4, 8), 4, 8);

			this.createGameBody(new SacredObject(4,5), 4, 5);

		}

	}

	public GameBody[][] getMap() { return map; }
	public GameBody getMapItem(int x, int y) { return map[x][y]; }
	public int getMapSize() { return MAP_SIZE; }
	public int[][] getIntMap() { return intMap; }


	public void movePlayer(int x, int y){
		if( intMap[playerTank.getX()+x][playerTank.getY()+y] == -1 ){
			this.destroyGameBody(playerTank);
			playerTank.move(x,y);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );
		}
		else{}
	}

	/*
	Runnable r = new Runnable() {
		public void run() {*/
			public void shootPlayer ( int direction){
				Bullet bullet;
				if (direction == 0) {
					bullet = new Bullet(playerTank.getX(), (playerTank.getY() - 1), playerTank.getShootSpeed(), direction);
					createGameBody(bullet, playerTank.getX(), playerTank.getY() - 1);
				} else if (direction == 1) {
					bullet = new Bullet(playerTank.getX() + 1, playerTank.getY(), playerTank.getShootSpeed(), direction);
					createGameBody(bullet,playerTank.getX() + 1, playerTank.getY());
				} else if (direction == 2) {
					bullet = new Bullet(playerTank.getX(), (playerTank.getY() + 1), playerTank.getShootSpeed(), direction);
					createGameBody(bullet, playerTank.getX(), playerTank.getY() + 1);
				} else if (direction == 3) {
					bullet = new Bullet(playerTank.getX() - 1, (playerTank.getY()), playerTank.getShootSpeed(), direction);
					createGameBody(bullet,playerTank.getX() - 1, playerTank.getY());
				}
			}/*
		}
	};
*/
	public void moveEnemy()  {
		boolean flag = true;
		int x = 0;
		int y = 0;
		int direction = 0;
		while( this.enemyTank.getHistToKill() > 0){
			try {
				Thread.sleep(150);
			} catch(InterruptedException e){
				return;
			}
			if(flag) {
				x = (-1) + (int) (Math.random() * 3);
				if( x != 0){
					y = 0;
					direction = x;
					// setting EnemyTank id for image arrangements
					if( direction == 1){
						enemyTank.setId(10);
					}
					else if(direction == -1){
						enemyTank.setId(11);
					}
				}
				flag = false;
			}
			else{
				y = (-1) + (int) (Math.random() * 3);
				if( y != 0){
					x = 0;
					direction = y;
					// setting EnemyTank id for image arrangements
					if( direction == 1){
						enemyTank.setId(12);
					}
					else if(direction == -1){
						enemyTank.setId(13);
					}
				}
				flag = true;
			}

			if( enemyTank.getX() + x < 10 && enemyTank.getX() + x > -1 && enemyTank.getY() + y < 10 && enemyTank.getY() + y > -1) {
				if (intMap[enemyTank.getX() + x][enemyTank.getY() + y] == -1) {
					this.destroyGameBody(enemyTank);
					enemyTank.move(x, y);
					this.createGameBody(enemyTank, enemyTank.getX(), enemyTank.getY());
				}
			}
		}
	}

	public void cleanMap(){
		for( int i = 0; i < this.getMapSize(); i++){
			for( int j = 0; j < this.getMapSize(); j++){
				if( map[i][j] != null) {
					destroyGameBody(map[i][j]);
				}
			}
		}
	}



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

}
