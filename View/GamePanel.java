package View;

import Controller.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel{
	/*
	Timer timer;
	int delay = 10;
	*/

	private BufferedImage playerTankU;
	private BufferedImage playerTankR;
	private BufferedImage playerTankD;
	private BufferedImage playerTankL;
	private BufferedImage enemyTank;
	private BufferedImage brickWall;
	private BufferedImage ironWall;
	private BufferedImage steelWall;
	private BufferedImage sacredObject;


	private int[][] intMap;
	private int dx = 0;
	private int dy = 0;
	private int direction = 0; // By Default -> points to the top

	public GamePanel( ){
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(1000, 1000));
		this.setLayout(null);
		this.setMaximumSize(this.getPreferredSize());
		this.addKeyListener(new KeyboardListener());
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		// this.timer = new Timer(this.delay, new TimerListener());
		try{
			this.playerTankU = ImageIO.read(new File("Resources/playerTankU.png"));
			this.playerTankD = ImageIO.read(new File("Resources/playerTankD.png"));
			this.playerTankL = ImageIO.read(new File("Resources/playerTankL.png"));
			this.playerTankR = ImageIO.read(new File("Resources/playerTankR.png"));
			this.enemyTank = ImageIO.read(new File("Resources/EnemyTank.png"));
			this.brickWall = ImageIO.read(new File("Resources/BrickWall.png"));
			this.ironWall = ImageIO.read(new File("Resources/IronWall.png"));
			this.steelWall = ImageIO.read(new File("Resources/SteelWall.png"));
			this.sacredObject = ImageIO.read(new File("Resources/SacredObject.png"));

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		//----------

		Font font = new Font("Century", 1, 20);
		JButton playButton = new JButton("LEFT");
		playButton.setSize( 150, 100 );
		playButton.setFont(font);
		this.add(playButton);
		playButton.setLocation(800,800);
		playButton.setOpaque(false);
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		playButton.setForeground(Color.RED);
		playButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Do Something Clicked");
			}
		});

		this.revalidate();
		//-------------

	}

	public void startGame() {
		this.removeAll();
		this.validate();
		this.repaint();
	}

	public void draw(int[][] map) {
		this.intMap = map;
		this.repaint();
	}



	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g.create();
		int xCoordinate = 0;
		int yCoordinate = 0;

		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j=j+1){
				if( intMap[i][j] != -1){
					if( intMap[i][j] == 0){
						if( this.direction == 0) {
							g2d.drawImage(this.playerTankU, (xCoordinate + (i * 100)), (yCoordinate + (j * 100)), 100, 100, Color.gray, null);
						}
						if( this.direction == 1) {
							g2d.drawImage(this.playerTankR, (xCoordinate + (i * 100)), (yCoordinate + (j * 100)), 100, 100, Color.gray, null);
						}
						if( this.direction == 2) {
							g2d.drawImage(this.playerTankD, (xCoordinate + (i * 100)), (yCoordinate + (j * 100)), 100, 100, Color.gray, null);
						}
						if( this.direction == 3) {
							g2d.drawImage(this.playerTankL, (xCoordinate + (i * 100)), (yCoordinate + (j * 100)), 100, 100, Color.gray, null);
						}
					}
					else if( intMap[i][j] == 1){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.enemyTank, (xCoordinate + (i*100)), (yCoordinate + (j*100)), 100, 100, Color.gray, null);
					}
					else if( intMap[i][j] == 3){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.brickWall, (xCoordinate + (i*100)), (yCoordinate + (j*100)), 100, 100, Color.gray, null);
					}
					else if( intMap[i][j] == 4){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.ironWall, (xCoordinate + (i*100)), (yCoordinate + (j*100)), 100, 100, Color.gray, null);
					}
					else if( intMap[i][j] == 5){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.steelWall, (xCoordinate + (i*100)), (yCoordinate + (j*100)), 100, 100, Color.gray, null);
					}
					else if( intMap[i][j] == 6){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.sacredObject, (xCoordinate + (i*100)), (yCoordinate + (j*100)), 100, 100, Color.gray, null);
					}
				}
			}
		}

	}


	private class TimerListener implements ActionListener {

		private TimerListener() {
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			MainFrame.getInstance().movePlayer(GamePanel.this.dx, GamePanel.this.dy);
			GamePanel.this.dx = 0;
			GamePanel.this.dy = 0;
		}
	}


	public class KeyboardListener implements KeyListener {
		public KeyboardListener() {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				case KeyEvent.VK_LEFT: {
					GamePanel.this.dx = -1;
					GamePanel.this.direction = 3;
					MainFrame.getInstance().movePlayer(GamePanel.this.dx, GamePanel.this.dy);
					break;
				}
				case KeyEvent.VK_UP: {
					GamePanel.this.dy = -1;
					GamePanel.this.direction = 0;
					MainFrame.getInstance().movePlayer(GamePanel.this.dx, GamePanel.this.dy);
					break;
				}
				case KeyEvent.VK_RIGHT: {
					GamePanel.this.dx = 1;
					GamePanel.this.direction = 1;
					MainFrame.getInstance().movePlayer(GamePanel.this.dx, GamePanel.this.dy);
					break;
				}
				case KeyEvent.VK_DOWN: {
					GamePanel.this.dy = 1;
					GamePanel.this.direction = 2;
					MainFrame.getInstance().movePlayer(GamePanel.this.dx, GamePanel.this.dy);
					break;
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				case 37: {
					dx = 0;
					break;
				}
				case 38: {
					dy = 0;
					break;
				}
				case 39: {
					dx = 0;
					break;
				}
				case 40: {
					dy = 0;
					break;
				}
			}
		}
	}

}