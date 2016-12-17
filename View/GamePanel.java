package View;

import Controller.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel{

	private BufferedImage playerTank;
	private BufferedImage enemyTank;
	private BufferedImage brickWall;
	private BufferedImage ironWall;
	private BufferedImage steelWall;
	private BufferedImage sacredObject;

	private int[][] intMap;


	public GamePanel( ){
		// this.intMap = game.getIntMap();

		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(1000, 1000));
		this.setLayout(null);
		this.setMaximumSize(this.getPreferredSize());
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		try{
			this.playerTank = ImageIO.read(new File("Resources/playerTank.png"));
			this.enemyTank = ImageIO.read(new File("Resources/EnemyTank.png"));
			this.brickWall = ImageIO.read(new File("Resources/BrickWall.png"));
			this.ironWall = ImageIO.read(new File("Resources/IronWall.png"));
			this.steelWall = ImageIO.read(new File("Resources/SteelWall.png"));
			this.sacredObject = ImageIO.read(new File("Resources/SacredObject.png"));

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void startGame() {
		this.removeAll();
		this.validate();
		this.repaint();
	}

	public void draw(int[][] map) {
		this.intMap = map;
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
			this.repaint();
		}
	}



	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g.create();
		int xCoordinate = 0;
		int yCoordinate = 0;

		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				if( intMap[i][j] != -1){
					if( intMap[i][j] == 0){
						//System.out.println( "at " + "( " + i + ", " + j + ")" + "  ->  " + intMap[i][j]);
						g2d.drawImage(this.playerTank, (xCoordinate + (i*100)), (yCoordinate + (j*100)), 100, 100, Color.gray, null);
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

}