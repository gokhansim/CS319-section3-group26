package Controller;

import Model.GameEngine;
import View.MainFrame;

import java.awt.image.BufferedImage;

public class Game {

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
		this.frame = MainFrame.getInstance(this);
		this.frame.setVisible(true);
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

	}

	public void moveEnemyTanks() {

	}

	public void shootPlayer() {

	}

	public void isLivesZero() {

	}

	public void updateView() {
		this.frame.updateView();
	}
}