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
	private BufferedImage crazedTankU;
	private BufferedImage crazedTankR;
	private BufferedImage crazedTankD;
	private BufferedImage crazedTankL;
	private BufferedImage panzerU;
	private BufferedImage panzerR;
	private BufferedImage panzerD;
	private BufferedImage panzerL;
	private BufferedImage brickWall;
	private BufferedImage ironWall;
	private BufferedImage steelWall;
	private BufferedImage sacredObject;
	private BufferedImage playerBulletU;
	private BufferedImage playerBulletR;
	private BufferedImage playerBulletD;
	private BufferedImage playerBulletL;
	private BufferedImage enemyBulletU;
	private BufferedImage enemyBulletR;
	private BufferedImage enemyBulletD;
	private BufferedImage enemyBulletL;
	private BufferedImage extraLife;
	private BufferedImage ultimateProtection;
	private BufferedImage shield;
	private BufferedImage doubleShots;

	private KeyboardListener keyboardListener;

	private int[][] intMap;
	private int dx = 0;
	private int dy = 0;
	private int direction = 0; // By Default -> points to the top

	
	private JLabel scores;
	private JLabel lives;


	public GamePanel( ){
		this.setBackground(Color.BLACK);
		//this.setPreferredSize(new Dimension(1200, 1000));
		//this.setMaximumSize(this.getPreferredSize());
		this.setPreferredSize(new Dimension(750, 750));
		this.setLayout(null);

		/*
		JLabel scoreLabel = new JLabel("score", JLabel.CENTER);
		scoreLabel.setForeground(Color.RED);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setBounds(100,100,200,30);
		scoreLabel.setSize(450,150);
		scoreLabel.setLocation(760,760);
		this.add(scoreLabel);
		*/

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
			
			this.crazedTankD = ImageIO.read(new File("Resources/crazedD.png"));
			this.crazedTankU = ImageIO.read(new File("Resources/crazedU.png"));
			this.crazedTankL = ImageIO.read(new File("Resources/crazedL.png"));
			this.crazedTankR = ImageIO.read(new File("Resources/crazedR.png"));
			
			this.panzerD = ImageIO.read(new File("Resources/panzerD.png"));
			this.panzerU = ImageIO.read(new File("Resources/panzerU.png"));
			this.panzerL = ImageIO.read(new File("Resources/panzerL.png"));
			this.panzerR = ImageIO.read(new File("Resources/panzerR.png"));
			
			this.brickWall = ImageIO.read(new File("Resources/BrickWall.png"));
			this.ironWall = ImageIO.read(new File("Resources/IronWall.png"));
			this.steelWall = ImageIO.read(new File("Resources/SteelWall.png"));
			this.sacredObject = ImageIO.read(new File("Resources/SacredObject.png"));
			
			this.playerBulletU = ImageIO.read(new File("Resources/playerBulletU.png"));
			this.playerBulletR = ImageIO.read(new File("Resources/playerBulletR.png"));
			this.playerBulletD = ImageIO.read(new File("Resources/playerBulletD.png"));
			this.playerBulletL = ImageIO.read(new File("Resources/playerBulletL.png"));

			this.enemyBulletU = ImageIO.read(new File("Resources/EnemyBulletU.png"));
			this.enemyBulletR = ImageIO.read(new File("Resources/EnemyBulletR.png"));
			this.enemyBulletD = ImageIO.read(new File("Resources/EnemyBulletD.png"));
			this.enemyBulletL = ImageIO.read(new File("Resources/EnemyBulletL.png"));

			this.shield = ImageIO.read(new File("Resources/Shield.png"));
			this.extraLife = ImageIO.read(new File("Resources/ExtraLife.png"));
			this.ultimateProtection = ImageIO.read(new File("Resources/UltimateProtection.png"));
			this.doubleShots = ImageIO.read(new File("Resources/DoubleShot.png"));

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
		/*
		scoreLabel.setBounds(100,100,200,30);
		scoreLabel.setSize(450,150);
		scoreLabel.setLocation(800,800);
		this.add(scoreLabel);
		this.revalidate();
		this.repaint();
		*/

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
							g2d.drawImage(this.playerTankD, (xCoordinate + (i * 75)), (yCoordinate + (j * 75)), 75, 75, Color.gray, null);
						}
						if( this.direction == 1) {
							g2d.drawImage(this.playerTankU, (xCoordinate + (i * 75)), (yCoordinate + (j * 75)), 75, 75, Color.gray, null);
						}
						if( this.direction == 2) {
							g2d.drawImage(this.playerTankR, (xCoordinate + (i * 75)), (yCoordinate + (j * 75)), 75, 75, Color.gray, null);
						}
						if( this.direction == 3) {
							g2d.drawImage(this.playerTankL, (xCoordinate + (i * 75)), (yCoordinate + (j * 75)), 75, 75, Color.gray, null);
						}
					}
					else if( intMap[i][j] == 10){
						g2d.drawImage(this.enemyTankR, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 11){
						g2d.drawImage(this.enemyTankL, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 12){
						g2d.drawImage(this.enemyTankD, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 13){
						g2d.drawImage(this.enemyTankU, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if (intMap[i][j] == 14) { // CRAZED UP
						g2d.drawImage(this.crazedTankR, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if (intMap[i][j] == 15) { // CRAZED DOWN
						g2d.drawImage(this.crazedTankL, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if (intMap[i][j] == 16) { // CRAZED LEFT
						g2d.drawImage(this.crazedTankD, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if (intMap[i][j] == 17) { // CRAZED RIGHT
						g2d.drawImage(this.crazedTankU, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if (intMap[i][j] == 18) { // PANZER UP
						g2d.drawImage(this.panzerR, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if (intMap[i][j] == 19) { // PANZER DOWN
						g2d.drawImage(this.panzerL, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if (intMap[i][j] == 20) { // PANZER LEFT
						g2d.drawImage(this.panzerD, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if (intMap[i][j] == 21) { // PANZER RIGHT
						g2d.drawImage(this.panzerU, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}


					//-------------------------------------------------------------------------------------------------
					//BULLETS
					//-------------------------------------------------------------------------------------------------

					else if( intMap[i][j] == 200){
						g2d.drawImage(this.enemyBulletU, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 210){
						g2d.drawImage(this.enemyBulletR, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 220){
						g2d.drawImage(this.enemyBulletD, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 230){
						g2d.drawImage(this.enemyBulletL, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 201){
						g2d.drawImage(this.playerBulletU, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 211){
						g2d.drawImage(this.playerBulletR, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 221){
						g2d.drawImage(this.playerBulletD, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 231){
						g2d.drawImage(this.playerBulletL, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					//-------------------------------------------------------------------------------------------------

					else if( intMap[i][j] == 3){
						g2d.drawImage(this.brickWall, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 4){
						g2d.drawImage(this.ironWall, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 5){
						g2d.drawImage(this.steelWall, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 6){
						g2d.drawImage(this.sacredObject, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 24){
						g2d.drawImage(this.extraLife, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 25){
						g2d.drawImage(this.doubleShots, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 26){
						g2d.drawImage(this.ultimateProtection, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
					}
					else if( intMap[i][j] == 27){
						g2d.drawImage(this.shield, (xCoordinate + (i*75)), (yCoordinate + (j*75)), 75, 75, Color.gray, null);
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
					GamePanel.this.direction = 1;
					MainFrame.getInstance().movePlayer(GamePanel.this.dx, GamePanel.this.dy);
					break;
				}
				case KeyEvent.VK_RIGHT: {
					GamePanel.this.dx = 1;
					GamePanel.this.direction = 2;
					MainFrame.getInstance().movePlayer(GamePanel.this.dx, GamePanel.this.dy);
					break;
				}
				case KeyEvent.VK_DOWN: {
					GamePanel.this.dy = 1;
					GamePanel.this.direction = 0;
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