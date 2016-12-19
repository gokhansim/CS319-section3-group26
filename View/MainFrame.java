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
	private JPanel activePanel;
	private boolean isClosed;


	public MainFrame( Game game){
		super("Siege");
		instance = this;
		this.game = game;
		this.setSize(1024, 768);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);

		// Panel initializations
		this.menuPanel = new MainMenuPanel();
		this.gamePanel = new GamePanel();
		this.helpPanel = new HelpPanel();
		this.settingsPanel = new SettingsPanel();
		this.scorePanel = new HighScorePanel();
		this.activePanel = menuPanel;
		
		///CHANGED
		this.add(gamePanel);
		this.add(menuPanel);
		this.add(helpPanel);
		this.add(settingsPanel);
		this.add(scorePanel);
		this.addKeyListener(gamePanel.new KeyboardListener());
		this.gamePanel.setFocusable(true);
		this.gamePanel.requestFocusInWindow();
		////
		
		this.container = new JPanel();
		this.container.setLayout(new BorderLayout());
		this.container.add((Component)this.activePanel, "Center");
		this.add( this.container);
		this.activePanel.setVisible(true);
		this.pack();
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


	public void updateView() {
		this.gamePanel.draw( game.getIntMap() );
	}

	public void updateStatusView(int status){
		this.getContentPane().removeAll();
		switch (status) {
			case 1: {
				this.setActivePanel(this.gamePanel);
				break;
			}
			case 3:{
				this.setActivePanel(this.settingsPanel);
				break;
			}
			case 5: {
				isClosed = true;
			}
		}
		if( !isClosed) {
			this.getContentPane().add(activePanel);
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}
		else{
			this.setVisible(false);
			this.dispose();
		}
	}

	public void changeCase( int caseNo){
		this.game.changeGameCase(caseNo);
	}

}