package Controller;

import Model.GameEngine;
import View.MainFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game{

    private Runnable r = new EnemyTankThread(this);
    Thread thr = new Thread(r);


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
		thr.start();
		this.frame = MainFrame.getInstance(this);
		this.frame.setVisible(true);
		// this.InputMngr = new InputManager();
		this.highScoreMngr = new HighScoreManager();
		//this.start();
		this.updateView();
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
		engine.moveEnemy();
		this.updateView();
	}

	public void shootPlayer(int direction) {
		engine.shootPlayer(direction);
		/*
		if( !(engine.getIsGameOver()) ) {
			this.updateView();
		}
		else{
			this.endGame();
		}
		*/

		if( !(engine.getIsGameOver()) && ( engine.getEnemyTanksLeft() != 0) ) {
			this.updateView();
		}
		else if( (engine.getIsGameOver()) && ( engine.getEnemyTanksLeft() != 0) ) {
			this.endGame();
		}
		else if( !(engine.getIsGameOver()) && ( engine.getEnemyTanksLeft() == 0) ){
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
			case 4:{
				this.frame.updateCaseView(caseNo);
				break;
			}
			case 5: {
				this.frame.updateCaseView(caseNo);
				break;
			}
		}

	}

	public void updateView() {
		this.frame.updateView();
	}


	// --  THREAD  ---------------------------------
	public class EnemyTankThread implements Runnable {
        private final Game game;

	    public EnemyTankThread( Game game){
            this.game = game;
        }

        public void run(){
	        game.moveEnemyTank();
        }
    }
    //-----------------------------------------------

}
