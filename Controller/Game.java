package Controller;

import Model.EnemyTank;
import Model.GameEngine;
import View.MainFrame;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game{
	/*
    private Runnable r = new EnemyTankThread(this);
    Thread thr = new Thread(r);
*/

	private int level;
	private int score;
	private int enemyTanksLeft;
	private int[][] intMap;
	private HighScoreManager highScoreMngr;
	private InputManager inputMngr;
	private SoundManager soundMngr;
	private SettingsManager settingsMngr;
	private MainFrame frame;
	private GameEngine engine;
	private int volume;
	/*
	private boolean running = false;
	private Thread thread;
	*/
	public Game(int level){
		engine = new GameEngine();
		settingsMngr = new SettingsManager(this);
		intMap = engine.getIntMap();
		this.score = 0;
		this.level = level;
		this.startLevel(this.level);
		//thr.start();
		this.frame = MainFrame.getInstance(this);
		this.frame.setVisible(true);
		// this.InputMngr = new InputManager();
		this.highScoreMngr = new HighScoreManager();
		//this.start();
		this.updateView();
		gameLoop();
	}

	// THREAD TRIALS
	/*
	public synchronized void start(){
		if( running){
			return;
		}

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop(){
		if( !running){
			return;
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();

		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				this.tick();
				delta--;
			}
			this.render();

			if( System.currentTimeMillis() - timer > 1000){
				timer += 1000;
			}
		}
		this.stop();
	}

	public void tick(){
		this.moveEnemyTank();
		this.shootPlayer();
		//this.movePlayer();
	}
	public void render(){
		this.updateView();
	}
	*/

	public int[][] getIntMap() { return intMap; }

	public void startLevel(int level) {
		this.level = level;
		engine.placeAllBodies(level);
	}

	public void endGame() {
		this.frame.updateCaseView(6);
	}

	public void updateScore(int score) {

	}

	public void writeHighScore(int score) {
		highScoreMngr.registerHighScore(score);
	}

	public void pauseGame() {

	}

	public void resumeGame() {

	}

	public void movePlayer(int x, int y) {
		engine.movePlayer(x, y);
		this.updateView();
	}

	public void moveEnemyTank() {
		
	}

	public void shootPlayer(int direction) {
		engine.shootTank(direction, engine.getPlayerTank());
		/*
		if( !(engine.getIsGameOver()) ) {
			this.updateView();
		}
		else{
			this.endGame();
		}
		*/

		if( !(engine.getIsGameOver()) && ( engine.getTank().size() != 0) ) {
			this.updateView();
		}
		else if( (engine.getIsGameOver()) && ( engine.getTank().size() != 0) ) {
			this.endGame();
		}
		else if( !(engine.getIsGameOver()) && ( engine.getTank().size() == 0) ){
			this.changeGameCase( 2, ++level);
		}

	}

	public void isLivesZero() {

	}

	public void changeGameCase(int caseNo, int level){
		switch (caseNo) {
			case 0: { // show main menu
				this.frame.updateCaseView(caseNo);
				break;
			}
			case 1: {
				this.startLevel(1);
				this.frame.startGame();
                this.frame.updateCaseView(caseNo);
				break;
			}
			// Level Change
            case 2: {
            	// this.level = level;
                this.settingsMngr.changeLevel(level);
				//this.frame.startGame();
                this.frame.updateCaseView(1);
                break;
            }
            // Settings Panel
			case 3:{
				this.frame.updateCaseView(caseNo);
				break;
			}
			//Help Panel
			case 4:{
				this.frame.updateCaseView(caseNo);
				break;
			}
			case 5: {
				this.frame.updateCaseView(caseNo);
				break;
			}
			case 7:{
				this.frame.updateCaseView(caseNo);
			}
		}

	}

	public void updateView() {
		this.frame.updateView();
	}


	public HighScoreManager getHighScoreManager(){
		return highScoreMngr;
	}
	public void gameLoop()
	{
	   long lastLoopTime = System.nanoTime();
	   final int TARGET_FPS = 1;
	   final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   
	   long lastFpsTime = 0;

	   // keep looping round til the game ends
	   while (true)
	   {
	      // work out how long its been since the last update, this
	      // will be used to calculate how far the entities should
	      // move this loop
	      long now = System.nanoTime();
	      long updateLength = now - lastLoopTime;
	      lastLoopTime = now;
	      double delta = updateLength / ((double)OPTIMAL_TIME);

	      // update the frame counter
	      lastFpsTime += updateLength;
	      
	      
	      // update our FPS counter if a second has passed since
	      // we last recorded
	      if (lastFpsTime >= 1000000000)
	      {
	         lastFpsTime = 0;
	      }
	      
	      // update the game logic
	      
	      this.doLoop(0);
	      
	      
	      // we want each frame to take 10 milliseconds, to do this
	      // we've recorded when we started the frame. We add 10 milliseconds
	      // to this and then factor in the current time to give 
	      // us our final value to wait for
	      // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
	   }
	}
	
	public void doLoop (int iter) {
		for ( int i = 0; i < engine.getTank().size(); i++) {
			engine.moveEnemy(engine.getTank().get(i));
			if ( iter % 10 == 0)
			engine.shootTank(engine.getTank().get(i).getId() % 4, engine.getTank().get(i));
		}
		for ( int i = 0; i < engine.getMapSize(); i++) {
			for ( int j = 0; j < engine.getMapSize(); j++) {
				if (engine.getMapItem(i, j) instanceof EnemyTank) {
					if (!engine.getTank().contains(engine.getMapItem(i, j))) {
						engine.destroyGameBody(engine.getMapItem(i,j));
					}
				}
			}
		}
		engine.moveBullet();
		iter++;
		this.updateView();
	}

	// --  THREAD  ---------------------------------
	public class EnemyTankThread implements Runnable {
        private final Game game2;

	    public EnemyTankThread( Game game){
             game2 = game;
        }

        public void run(){
        	
        }
    }
	//-----------------------------------------------

}
