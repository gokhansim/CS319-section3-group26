package View;

import Controller.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame{

	private static MainFrame instance = null;
	private Game game;
	private JPanel container;
	private GamePanel gamePanel;


	private JPanel activePanel;
	private ArrayList<Panel> panels;


	public MainFrame( Game game){
		super("Siege");
		instance = this;
		this.game = game;
		this.setSize(1024, 768);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.container = new JPanel();
		this.gamePanel = new GamePanel();
		this.container.setLayout(new BorderLayout());
		this.container.add((Component)this.gamePanel, "Center");
		this.add( this.container);
		this.gamePanel.setVisible(true);
		this.pack();
	}

	public static MainFrame getInstance() {
		return instance;
	}

	public static MainFrame getInstance(Game game) {
		instance = new MainFrame(game);
		return instance;
	}

	public void startGame() {
		this.gamePanel.startGame();
	}


	public void updateView() {
		this.gamePanel.draw( game.getIntMap() );
	}


}