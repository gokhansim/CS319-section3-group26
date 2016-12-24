package Model;

import java.util.ArrayList;
public class GameEngine {

	protected static final int MAP_SIZE = 10;

	private GameBody[][] map;
	protected int[][] intMap;
	private CollisionManager colMngr;
	private int score;
	private int enemyTanksLeft; 
	protected boolean isGameOver;
	
	private PlayerTank playerTank; // the player tank
	
	private ArrayList<EnemyTank> tank; // list of the enemy tanks that are active in the game
	private ArrayList<Bullet> bulletList; //list of the bullets that are active in the game

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
		this.playerTank = new PlayerTank(4,7);
		tank = new ArrayList<EnemyTank>();
		bulletList =  new ArrayList<Bullet>();
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
	public void moveBullet() {
		for( int i = 0; i < bulletList.size(); i++){
			checkBullet(bulletList.get(i));
		}

	}
	//	----

	public void addScore( int scoreGiven){ score = score + scoreGiven; }
	public int getScore() { return score; }
	public boolean getIsGameOver() { 
		return isGameOver; 
	}

	public int getEnemyTanksLeft(){ return enemyTanksLeft; }
	public void setEnemyTanksLeft( int enemyTanksLeft){ this.enemyTanksLeft = enemyTanksLeft;}
	public void decreaseEnemyTanksLeft() { this.enemyTanksLeft--;}

	// places new GameBody in the map.
	public void createGameBody(GameBody body, int x, int y) {
		GameBody aBody = body;
		if( map[x][y] == null ) {
			map[x][y] = aBody;

			if( aBody instanceof Bullet){
				bulletList.add((Bullet)aBody);
			}
			intMap[x][y] = aBody.getID();

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
		if ( body instanceof Bullet) 
			bulletList.remove(body);
	}
	/////////////////////////////////////////////////////////////
	// CONSTRUCTING THE LEVELS INDIVIDUALLY IN THE FOLLOWING SEGMENT
	public void placeAllBodies(int level){
		if( level == 1){
			this.cleanMap();
			tank.clear();
			this.setEnemyTanksLeft(2);

			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );


			tank.add(new EnemyTank(0,0));
			this.createGameBody(tank.get(0), tank.get(0).getX(), tank.get(0).getY() );
			tank.add(new EnemyTank(6,0));
			this.createGameBody(tank.get(1), tank.get(1).getX(), tank.get(1).getY() );

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

		}

		else if(level == 2){
			this.cleanMap();
			this.tank.clear();
			playerTank.setX(9);
			playerTank.setY(9);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			tank.add(new EnemyTank(0,0));
			tank.add(new CrazedTank(9,0));//will be change to crazed 
			tank.add(new EnemyTank(0,9)); //this will be changed to crazed

			for ( int i = 0; i < tank.size(); i++) {
				this.createGameBody(tank.get(i), tank.get(i).getX(), tank.get(i).getY() );
			}
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
			this.tank.clear();
			this.playerTank.setX(4);
			this.playerTank.setY(8);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			this.tank.add(new EnemyTank(0, 0 ));
			this.tank.add(new CrazedTank(9, 0 ));//will be change to crazed 
			this.tank.add(new Panzer(0, 9 )); //this will be changed to crazed
			this.tank.add(new Panzer(9, 9 )); 		
			
			for ( int i = 0; i < tank.size(); i++) {
				this.createGameBody(tank.get(i), tank.get(i).getX(), tank.get(i).getY() );
			}

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
			this.tank.clear();
			this.playerTank.setX(4);
			this.playerTank.setY(4);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			this.tank.add(new EnemyTank(0, 0 ));
			this.tank.add(new CrazedTank(9, 0));
			this.tank.add(new CrazedTank(0, 6)); 
			this.tank.add(new Panzer(9, 6)); 
			this.tank.add(new Panzer(2, 2)); 
			this.tank.add(new Panzer(6, 2)); 
			
			for ( int i = 0; i < tank.size(); i++) {
				this.createGameBody(tank.get(i), tank.get(i).getX(), tank.get(i).getY() );
			}
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
			this.tank.clear();
			this.playerTank.setX(4);
			this.playerTank.setY(7);
			this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );

			this.tank.add(new Panzer(0,0));
			this.tank.add(new CrazedTank(9,0));//will be change to crazed 
			this.tank.add(new CrazedTank(0,9)); //this will be changed to crazed
			this.tank.add(new Panzer(9,9)); 					
			this.tank.add(new Panzer(2,2)); //this will be changed to crazed
			this.tank.add(new Panzer(7,2)); 	

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

	public void movePlayer(int x, int y){
		if (playerTank.getX() + x < 10 && playerTank.getX() + x > -1 && playerTank.getY() + y < 10 && playerTank.getY() + y > -1) {
			if( intMap[playerTank.getX()+x][playerTank.getY()+y] == -1 ){
				this.destroyGameBody(playerTank);
				playerTank.move(x,y);
				this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );
			}
			else if (map[playerTank.getX()+x][playerTank.getY()+y] instanceof PowerUp) {
				this.colMngr.checkCollision(this.playerTank, map[playerTank.getX()+x][playerTank.getY()+y], this);
				this.destroyGameBody(playerTank);
				playerTank.move(x,y);
				this.createGameBody(playerTank, playerTank.getX(), playerTank.getY() );
			}
		}
	}

	public void shootTank ( int direction, Tank t){
		Bullet bullet;
		if (direction == 1) {
			if (t.getY() - 1 > -1) {
				if( t instanceof PlayerTank){
					bullet = new Bullet(t.getX(), (t.getY() - 1), t.getShootSpeed(), direction,1);
					createGameBody(bullet, t.getX(), t.getY() - 1);
				}
				else if (t instanceof EnemyTank) {
					bullet = new Bullet(t.getX(), (t.getY() - 1), t.getShootSpeed(), direction, 0);
					createGameBody(bullet, t.getX(), t.getY() - 1);
				}
			}
		} else if (direction == 2) {
			if (t.getX() + 1 < 10) {
				if( t instanceof PlayerTank){
					bullet = new Bullet(t.getX() + 1, (t.getY()), t.getShootSpeed(), direction,1);
					createGameBody(bullet, t.getX() + 1, t.getY());
				}
				else{
					bullet = new Bullet(t.getX() + 1, (t.getY()), t.getShootSpeed(), direction, 0);
					createGameBody(bullet, t.getX() + 1, t.getY());
				}
			}
		} else if (direction == 0) {
			if (t.getY() + 1 < 10) {
				if( t instanceof PlayerTank){
					bullet = new Bullet(t.getX(), (t.getY() + 1), t.getShootSpeed(), direction,1);
					createGameBody(bullet, t.getX(), t.getY() + 1);
				}
				else{
					bullet = new Bullet(t.getX(), (t.getY() + 1), t.getShootSpeed(), direction, 0);
					createGameBody(bullet, t.getX(), t.getY() + 1);
				}

			}
		} else if (direction == 3) {
			if (t.getX() - 1 > -1) {
				if( t instanceof PlayerTank){
					bullet = new Bullet(t.getX() - 1, (t.getY()), t.getShootSpeed(), direction,1);
					createGameBody(bullet, t.getX() - 1, t.getY());
				}
				else{
					bullet = new Bullet(t.getX() - 1, (t.getY()), t.getShootSpeed(), direction, 0);
					createGameBody(bullet, t.getX() - 1, t.getY());
				}

			}
		}
	}


	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public void moveEnemy(EnemyTank t)  {
		boolean flag = true;
		int x = 0;
		int y = 0;
		int dir = t.getID() % 4; 
		// for dir;
		// 0 - down 1 - up 2 - right 3- left
		//int direction = 0;
		if( t.getHistToKill() > 0){
			try {
				Thread.sleep(100);
			} catch(InterruptedException e){
				return;
			}
			if ( flag) {
				int next = (int) (Math.random() * 100);
				if ( next < 30 || isBlocked(t)) {
					int a = (int) (Math.random() * 4);
					if ( a == 0) { 
						y = 1; // DOWN
						if ( t instanceof CrazedTank)
							t.setID(16);
						else if ( t instanceof Panzer)
							t.setID(20);
						else
							t.setID(12);
					}
					else if (a == 1) {
						y = -1; //UP
						if ( t instanceof CrazedTank)
							t.setID(17);
						else if ( t instanceof Panzer)
							t.setID(21);
						else
							t.setID(13);
					}
					else if (a == 2){
						x = 1;
						if ( t instanceof CrazedTank)
							t.setID(14);
						else if ( t instanceof Panzer)
							t.setID(18);
						else
							t.setID(10);
					}
					else if (a == 3) {
						x = -1;
						if ( t instanceof CrazedTank)
							t.setID(15);
						else if ( t instanceof Panzer)
							t.setID(19);
						else
							t.setID(11);
					}
				}
				else { 
					switch(dir) {
					case 0:
						y = 1;
						if ( t instanceof CrazedTank)
							t.setID(16);
						else if ( t instanceof Panzer)
							t.setID(20);
						else
							t.setID(12);
						break;
					case 1:
						y = -1;
						if ( t instanceof CrazedTank)
							t.setID(17);
						else if ( t instanceof Panzer)
							t.setID(21);
						else
							t.setID(13);
						break;
					case 2:
						x = 1;
						if ( t instanceof CrazedTank)
							t.setID(14);
						else if ( t instanceof Panzer)
							t.setID(18);
						else
							t.setID(10);
						break;
					case 3:
						x = -1;
						if ( t instanceof CrazedTank)
							t.setID(15);
						else if ( t instanceof Panzer)
							t.setID(19);
						else
							t.setID(11);
						break;
					}

				}
				flag = false;
			}
			else {
				int next = (int) (Math.random() * 100);
				if ( next < 40 || isBlocked(t)) {
					int a = (int) (Math.random() * 4);
					if ( a == 0) { 
						y = 1; // DOWN
						if ( t instanceof CrazedTank)
							t.setID(16);
						else if ( t instanceof Panzer)
							t.setID(20);
						else
							t.setID(12);
					}
					else if (a == 1) {
						y = -1; //UP
						if ( t instanceof CrazedTank)
							t.setID(17);
						else if ( t instanceof Panzer)
							t.setID(21);
						else
							t.setID(13);
					}
					else if (a == 2){
						x = 1;
						if ( t instanceof CrazedTank)
							t.setID(14);
						else if ( t instanceof Panzer)
							t.setID(18);
						else
							t.setID(10);
					}
					else if (a == 3) {
						x = -1;
						if ( t instanceof CrazedTank)
							t.setID(15);
						else if ( t instanceof Panzer)
							t.setID(19);
						else
							t.setID(11);
					}
				}
				else { 
					switch(dir) {
					case 0:
						y = 1;
						if ( t instanceof CrazedTank)
							t.setID(16);
						else if ( t instanceof Panzer)
							t.setID(20);
						else
							t.setID(12);
						break;
					case 1:
						y = -1;
						if ( t instanceof CrazedTank)
							t.setID(17);
						else if ( t instanceof Panzer)
							t.setID(21);
						else
							t.setID(13);
						break;
					case 2:
						x = 1;
						if ( t instanceof CrazedTank)
							t.setID(14);
						else if ( t instanceof Panzer)
							t.setID(18);
						else
							t.setID(10);
						break;
					case 3:
						x = -1;
						if ( t instanceof CrazedTank)
							t.setID(15);
						else if ( t instanceof Panzer)
							t.setID(19);
						else
							t.setID(11);
						break;
					}

				}
				flag = true;
			}

			if( t.getX() + x < 10 && t.getX() + x > -1 && t.getY() + y < 10 && t.getY() + y > -1) {
				if (intMap[t.getX() + x][t.getY() + y] == -1) {
					this.destroyGameBody(t);
					t.move(x, y);
					this.createGameBody(t, t.getX(), t.getY());
				}

			}
			else {
				moveEnemy(t);
			}
		}
		else {
			tank.remove(t);
			this.destroyGameBody(t);
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

	public boolean isBlocked(Tank t) {
		int dir = t.getID() % 4;
		if ( t.getX() - 1 > -1 && t.getX() + 1 < 10 && t.getY() - 1 > -1 && t.getY() + 1 < 10) {
			if ( dir == 0 && intMap[t.getX()][t.getY()+1] != -1) 
				return true;
			else if ( dir == 1 && intMap[t.getX()][t.getY()-1] != -1) 
				return true;
			else if ( dir == 2 && intMap[t.getX() + 1][t.getY()] != -1)
				return true;
			else if ( dir == 3 && intMap[t.getX() - 1][t.getY()] != -1)
				return true;
			else 
				return false;
		}
		else 
			return false;
	}

	public void checkBullet(Bullet b) {
		if( b.getID() == 230 || b.getID() == 231){
			if ( b.getX() - 1 >= 0) {
				this.destroyGameBody(b);
				b.move(-1, 0);
				this.createGameBody( b, b.getX(), b.getY());
			}
			else {
				this.destroyGameBody(b);
				removeBullet(b);
			}
		}
		else if( b.getID() == 220 || b.getID() == 221){
			if ( b.getY() + 1 < 10) {
				this.destroyGameBody(b);
				b.move(0, 1);
				this.createGameBody( b, b.getX(), b.getY());
			}
			else {
				this.destroyGameBody(b);
				removeBullet(b);
			}
		}
		else if( b.getID() == 210 || b.getID() == 211){
			if ( b.getX() +1 < 10) {
				this.destroyGameBody(b);
				b.move(1, 0);
				this.createGameBody( b, b.getX(), b.getY());
			}
			else {
				this.destroyGameBody(b);
				removeBullet(b);
			}
		}
		else if( b.getID() == 200 || b.getID() == 201){
			if (b.getY() - 1 >= 0) {
				this.destroyGameBody(b);
				b.move(0, -1);
				this.createGameBody( b, b.getX(), b.getY());
			}
			else {
				this.destroyGameBody(b);
				removeBullet(b);
			}
		}
	}

	public void spawnPowerup() {
		int num = 0;

		for ( int i = 0; i < this.MAP_SIZE; i++) {
			for ( int j = 0; j < this.MAP_SIZE; j++) {
				if (this.intMap[i][j] == -1) 
					num++;
			}
		}
		int rand = (int) (Math.random() * num);
		int k = 0, x = 0, y = 0;
		boolean flag = true;
		for ( int i = 0; i < this.MAP_SIZE && flag; i++) {
			for ( int j = 0; j < this.MAP_SIZE && flag; j++) {
				k++;
				if (k == rand) {
					flag = false;
					x = i;
					y = j;
				}

			}
		}
		int powrand = (int) (Math.random() * 4);
		switch (powrand) {
		case 0:
			this.createGameBody(new Shield(x, y), x, y);
		case 1: 
			this.createGameBody(new ExtraLife(x,y), x, y);
		case 2:
			this.createGameBody(new DoubleShots(x,y), x, y);
		case 3: 
			this.createGameBody(new UltimateProtection(x,y), x, y);
		}
	}

	public void updateMap() {

	}
	////////////////////////////////////////////
	///////////GETTER AND SETTERS///////////////
	////////////////////////////////////////////
	
	public ArrayList<EnemyTank> getTank() {
		return tank;
	}

	public void setTank(ArrayList<EnemyTank> tank) {
		this.tank = tank;
	}

	public PlayerTank getPlayerTank() {
		return playerTank;
	}

	public void setPlayerTank(PlayerTank playerTank) {
		this.playerTank = playerTank;
	}

	public GameBody[][] getMap() { 
		return map; 
	}

	public void setMap(GameBody[][] map) {
		this.map = map;
	}

	public GameBody getMapItem(int x, int y) { 
		return map[x][y]; 
	}

	public void setMapItem(int x, int y, GameBody body) {
		this.map[x][y] = body;
	}

	public int getMapSize() { 
		return MAP_SIZE; 
	}
	public int[][] getIntMap() { 
		return intMap; 
	}
}
