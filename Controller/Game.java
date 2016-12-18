package Controller;

import Model.GameEngine;
import View.MainFrame;

import java.awt.image.BufferedImage;

public class Game {

    private Runnable r = new EnemyTankThread(this);
    Thread thr = new Thread(r);

	private int level;
	private int score;
	private int enemyTanksLeft;
	private int[][] intMap;
	private HighScoreManager HighScoreMngr;
	private InputManager InputMngr;
	private SoundManager SoundMngr;
	private SettingsManager SettingsMngr;
	private MainFrame frame;
	private GameEngine engine;
	private int volume;

	public Game(int level){
		engine = new GameEngine();
		intMap = engine.getIntMap();
		this.score = 0;
		this.level = level;
		this.startLevel(this.level);
		thr.start();
		this.frame = MainFrame.getInstance(this);
		this.frame.setVisible(true);
		// this.InputMngr = new InputManager();
		this.updateView();
	}

	public int[][] getIntMap() { return intMap; }

	public void startLevel(int level) {
		engine.placeAllBodies(level);
	}

	public void endGame() {

	}

	public void updateScore(int score) {

	}

	public void writeHighScore(int score) {

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

	public void shootPlayer() {

	}

	public void isLivesZero() {

	}

	public void changeGameCase(int caseNo){
		switch (caseNo) {
			case 1: {
				this.frame.startGame();
				break;
			}
			case 5: {
				// Not Decided Yet.
				break;
			}
		}
		this.frame.updateStatusView(caseNo);
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