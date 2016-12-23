package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
	private BufferedImage enemyTankU;
	private BufferedImage enemyTankR;
	private BufferedImage enemyTankD;
	private BufferedImage enemyTankL;
	private BufferedImage brickWall;
	private BufferedImage ironWall;
	private BufferedImage steelWall;
	private BufferedImage sacredObject;
	private BufferedImage bulletU;
	private BufferedImage bulletR;
	private BufferedImage bulletD;
	private BufferedImage bulletL;

	private KeyboardListener keyboardListener;

	private int[][] intMap;
	private int dx = 0;
	private int dy = 0;
	private int direction = 0; // By Default -> points to the top
<<<<<<< HEAD
=======
	
	private JLabel scores;
	private JLabel lives;
>>>>>>> c96a6381039ba6d61a5bcec783588cd714aebadc

	public GamePanel( ){
		this.setBackground(Color.BLACK);
		//this.setPreferredSize(new Dimension(1200, 1000));
		//this.setMaximumSize(this.getPreferredSize());
		this.setPreferredSize(new Dimension(750, 800));
		this.setLayout(null);
		//
		JLabel scoreLabel = new JLabel("score", JLabel.CENTER);
		scoreLabel.setForeground(Color.RED);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setBounds(100,100,200,30);
		scoreLabel.setSize(450,150);
		scoreLabel.setLocation(760,760);
		this.add(scoreLabel);
		//
		this.setMaximumSize(this.getPreferredSize());
		keyboardListener = new KeyboardListener();
		this.addKeyListener( keyboardListener );
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		
		/*
		this.scores = new JLabel("Score: 0");
		this.scores.setBackground(Color.GRAY);
		this.add(scores, "East");
		
		this.lives = new JLabel("Lives: 3");
		this.add(lives, "East");
		*/
		this.repaint();

		// this.timer = new Timer(this.delay, new TimerListener());
		try{
			this.playerTankU = ImageIO.read(new File("Resources/playerTankU.png"));
			this.playerTankD = ImageIO.read(new File("Resources/playerTankD.png"));
			this.playerTankL = ImageIO.read(new File("Resources/playerTankL.png"));
			this.playerTankR = ImageIO.read(new File("Resources/playerTankR.png"));
			this.enemyTankU = ImageIO.read(new File("Resources/EnemyTankU.png"));
			this.enemyTankR = ImageIO.read(new File("Resources/EnemyTankR.png"));
			this.enemyTankD = ImageIO.read(new File("Resources/EnemyTankD.png"));
			this.enemyTankL = ImageIO.read(new File("Resources/EnemyTankL.png"));
			this.brickWall = ImageIO.read(new File("Resources/BrickWall.png"));
			this.ironWall = ImageIO.read(new File("Resources/IronWall.png"));
			this.steelWall = ImageIO.read(new File("Resources/SteelWall.png"));
			this.sacredObject = ImageIO.read(new File("Resources/SacredObject.png"));
			this.bulletU = ImageIO.read(new File("Resources/BulletU.png"));
			this.bulletR = ImageIO.read(new File("Resources/BulletR.png"));
			this.bulletD = ImageIO.read(new File("Resources/BulletD.png"));
			this.bulletL = ImageIO.read(new File("Resources/BulletL.png"));

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		//----------

		JLabel scoreLabel = new JLabel("score", JLabel.CENTER);
		scoreLabel.setOpaque(true);
		// scoreLabel.setFont();
		scoreLabel.setForeground(Color.RED);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setBounds(100,100,200,30);
		scoreLabel.setSize(450,150);
		scoreLabel.setLocation(800,800);
		this.add(scoreLabel);
		this.revalidate();
		this.repaint();

		//----------

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
							g2d.drawImage(this.playerTankU, (xCoordinate + (i * 75)), (yCoordinate + (j * 75)), 75, 75, Color.gray, null);
						}
						if( this.direction == 1) {
							g2d.drawImage(this.playerTankR, (xCoordinate + (i * 75)), (yCoordinate + (j * 75)), 75, 75, Color.gray, null);
						}
						if( this.direction == 2) {
							g2d.drawImage(this.playerTankD, (xCoordinate + (i * 75)), (yCoordinate + (j * 75)), 75, 75, Color.gray, null);
						}
						if( this.direction == 3) {
							g2d.drawImage(this.playerTankL, (xCoordinate + (i * 75)), (yCoordinate + (j * 75)), 75, 75, Color.gray, null);
						}
					}
					else if( intMap[i][j] == 10){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.enemyTankR, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 11){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.enemyTankL, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 12){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.enemyTankD, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 13){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.enemyTankU, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 20){
						g2d.drawImage(this.bulletU, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 21){
						g2d.drawImage(this.bulletR, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 22){
						g2d.drawImage(this.bulletD, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 23){
						g2d.drawImage(this.bulletL, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 3){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.brickWall, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 4){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.ironWall, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 5){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.steelWall, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 6){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.sacredObject, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
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
				case KeyEvent.VK_SPACE: {
					MainFrame.getInstance().shootPlayer(GamePanel.this.direction);
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