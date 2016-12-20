package View;

import Controller.HighScoreManager;

import static java.awt.Font.createFont;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.*;

public class HighScorePanel extends JPanel {

	private Font customFont;
	private Font buttonFont;
	private Font hoverFont;
	MenuListener menuListener;
	
	public HighScorePanel(HighScoreManager hsm){
	
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(1000, 1000));
        this.setLayout(null);
       	menuListener = new MenuListener();
        
		try {
		    this.customFont = createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")).deriveFont(50f);
		    this.buttonFont = customFont.deriveFont(30f);
		    this.hoverFont = customFont.deriveFont(33f);
		}
		catch (IOException e) {
		    this.customFont = new Font("Century", 1, 20);
		    this.buttonFont = new Font("Century", 1, 20);
		}
		catch (FontFormatException e) {
		    this.customFont = new Font("Century", 1, 20);
		    this.buttonFont = new Font("Century", 1, 20);
		}
		
		//High Scores Label
		JLabel scoresLabel = new JLabel("HIGH SCORES", JLabel.CENTER);
		scoresLabel.setOpaque(true);
		scoresLabel.setFont(this.customFont);
		scoresLabel.setForeground(Color.RED);
		scoresLabel.setBackground(Color.BLACK);
		scoresLabel.setSize(450,150);
		scoresLabel.setLocation(265,30);
		this.add(scoresLabel);

		JLabel firstScoreLabel;
		JLabel secondScoreLabel;
		JLabel thirdScoreLabel;
		JLabel fourthScoreLabel;
		JLabel fifthScoreLabel;

		//ArrayList<Integer> scoreList = new ArrayList<Integer>();
	      	//scoreList = hsm.showHighScore();

	       //if(scoreList.get(0) != -1)
		//	firstScoreLabel = new JLabel(("1. " + Integer.toString(scoreList.get(0))), JLabel.CENTER );
	       //else 
			firstScoreLabel = new JLabel("1. -", JLabel.CENTER);

	       //if(scoreList.get(1) != -1)
		//	secondScoreLabel = new JLabel(("2. " + Integer.toString(scoreList.get(1))), JLabel.CENTER );
	       //else 
			secondScoreLabel = new JLabel("2. -", JLabel.CENTER);

	       //if(scoreList.get(1) != -1)
		//	thirdScoreLabel = new JLabel(("3. " + Integer.toString(scoreList.get(2))), JLabel.CENTER );
	      // else 
			thirdScoreLabel = new JLabel("3. -", JLabel.CENTER);

		//if(scoreList.get(1) != -1)
		//	fourthScoreLabel = new JLabel(("4. " + Integer.toString(scoreList.get(3))), JLabel.CENTER );
		//else 
			fourthScoreLabel = new JLabel("4. -", JLabel.CENTER);

		//if(scoreList.get(1) != -1)
		//	//fifthScoreLabel = new JLabel(("5. " + Integer.toString(scoreList.get(4))), JLabel.CENTER );
		//else 
			fifthScoreLabel = new JLabel("5. -", JLabel.CENTER);

		firstScoreLabel.setOpaque(true);
		firstScoreLabel.setFont(this.customFont);
		firstScoreLabel.setForeground(Color.RED);
		firstScoreLabel.setBackground(Color.BLACK);
		firstScoreLabel.setSize(450,150);
		firstScoreLabel.setLocation(265,150);

		secondScoreLabel.setOpaque(true);
		secondScoreLabel.setFont(this.customFont);
		secondScoreLabel.setForeground(Color.RED);
		secondScoreLabel.setBackground(Color.BLACK);
		secondScoreLabel.setSize(450,150);
		secondScoreLabel.setLocation(265,270);

		thirdScoreLabel.setOpaque(true);
		thirdScoreLabel.setFont(this.customFont);
		thirdScoreLabel.setForeground(Color.RED);
		thirdScoreLabel.setBackground(Color.BLACK);
		thirdScoreLabel.setSize(450,150);
		thirdScoreLabel.setLocation(265,390);

		fourthScoreLabel.setOpaque(true);
		fourthScoreLabel.setFont(this.customFont);
		fourthScoreLabel.setForeground(Color.RED);
		fourthScoreLabel.setBackground(Color.BLACK);
		fourthScoreLabel.setSize(450,150);
		fourthScoreLabel.setLocation(265,510);

		fifthScoreLabel.setOpaque(true);
		fifthScoreLabel.setFont(this.customFont);
		fifthScoreLabel.setForeground(Color.RED);
		fifthScoreLabel.setBackground(Color.BLACK);
		fifthScoreLabel.setSize(450,150);
		fifthScoreLabel.setLocation(265,630);

		this.add(firstScoreLabel);
		this.add(secondScoreLabel);
		this.add(thirdScoreLabel);
		this.add(fourthScoreLabel);
		this.add(fifthScoreLabel);

		//Back to main menu button 
		JButton backToMain = new JButton("Back");
		backToMain.setFont(this.buttonFont);
		backToMain.setSize( 300, 200 );
		this.add(backToMain);
		backToMain.setLocation(45,750);
		backToMain.setOpaque(false);
		backToMain.setContentAreaFilled(false);
		backToMain.setBorderPainted(false);
		backToMain.setForeground(Color.RED);
		backToMain.addActionListener(menuListener);
		backToMain.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt){
			backToMain.setFont(hoverFont);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
			backToMain.setFont(buttonFont);
		    }
		});
	}
        
        private class MenuListener implements ActionListener{
        	
        	private MenuListener(){}

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			String str;
    			Object obj = e.getSource();
    			switch (str = ((JButton)obj).getText()){
    				case "Back":{
					MainFrame.getInstance().changeCase(0, 1);
					break;
					}
    			}
    		}
    	}
}
