package View;

import Controller.Game;
import View.GamePanel.KeyboardListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame{

	private static MainFrame instance = null;
	private Game game;
	private JPanel container;
	private GamePanel gamePanel;
	private MainMenuPanel menuPanel;
	private SettingsPanel settingsPanel;
	private HelpPanel helpPanel;
	private HighScorePanel scorePanel;
	private GameOverPanel gameOverPanel;
	private JPanel activePanel;
	private boolean isClosed;

	public MainFrame( Game game){
		super("Siege");
		instance = this;
		this.game = game;
		this.setResizable(true);
		this.setSize(750, 800);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);

		// Panel initializations
		this.menuPanel = new MainMenuPanel();
		this.gamePanel = new GamePanel();
		this.helpPanel = new HelpPanel();
		this.settingsPanel = new SettingsPanel();
		this.scorePanel = new HighScorePanel(game.getHighScoreManager());
		this.gameOverPanel = new GameOverPanel();
		this.activePanel = menuPanel;
		
		///CHANGED
		this.add(gamePanel);
		this.add(menuPanel);
		this.add(helpPanel);
		this.add(settingsPanel);
		this.add(scorePanel);
		this.add(gameOverPanel);
		// this.add(gameScorePanel);
		// this.addKeyListener(gamePanel.new KeyboardListener());
		this.gamePanel.setFocusable(true);
		this.gamePanel.requestFocusInWindow();
	
		
		this.container = new JPanel();
		this.container.setLayout(new BorderLayout());
		this.container.add((Component)this.activePanel, "Center");
		this.add(this.container);
		this.container.setVisible(true);
		this.pack();
		
		/*
		 * To make the game full screen, uncomment the following. Put this.pack() in between the two lines.
		 */
		//Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setSize(screen.width, screen.height);
	}

	public static MainFrame getInstance() {
		return instance;
	}

	public static MainFrame getInstance(Game game) {
		instance = new MainFrame(game);
		return instance;
	}

	public void setActivePanel(JPanel activePanel){ this.activePanel = activePanel; }

	public void startGame() {
		this.gamePanel.startGame();
	}

	public void movePlayer( int x, int y){
		this.game.movePlayer(x,y);
	}

	public void shootPlayer(int direction){
		this.game.shootPlayer(direction);
	}

	public void updateView() {
		this.gamePanel.draw( game.getIntMap() );
	}

	public void updateCaseView(int caseNo){
		this.getContentPane().removeAll();
		switch (caseNo) {
			case 0: {
				this.setActivePanel(this.menuPanel);
				break;
			}
			case 1: {
				this.setActivePanel(this.gamePanel);
				break;
			}
			case 3:{
				this.setActivePanel(this.settingsPanel);
				break;
			}
			case 4: {
				this.setActivePanel(this.helpPanel);
				break;
			}
			case 5: {
				isClosed = true;
			}
			case 6: { // GameOver panel would be shown
				this.setActivePanel(this.gameOverPanel);
				break;
			}
			case 7:{
				this.setActivePanel(this.scorePanel);
				break;
			}
		}
		if( !isClosed) {
			this.getContentPane().add(activePanel);
			activePanel.requestFocusInWindow();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}
		else{
			this.setVisible(false);
			this.dispose();
		}
	}

	public void changeCase( int caseNo, int level) {
		this.game.changeGameCase(caseNo, level);
	}

}
