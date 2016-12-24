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
	HighScoreManager hsm;
	
	public HighScorePanel(){
	
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(750, 800));
       		this.setLayout(null);
      	 	menuListener = new MenuListener();
		hsm = new HighScoreManager();
        
		try {
		    this.customFont = createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")).deriveFont(50f);
		    this.buttonFont = customFont.deriveFont(27f);
		    this.hoverFont = customFont.deriveFont(30f);
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
		scoresLabel.setLocation(165,30);
		this.add(scoresLabel);

		JLabel firstScoreLabel;
		JLabel secondScoreLabel;
		JLabel thirdScoreLabel;
		JLabel fourthScoreLabel;
		JLabel fifthScoreLabel;

		try{
			firstScoreLabel = new JLabel(("1. " + Integer.toString(hsm.showHighScore().get(0))), JLabel.CENTER );
	       }
	       catch(NullPointerException e) {
	       		firstScoreLabel = new JLabel("1. -", JLabel.CENTER);
	       }
		catch(IndexOutOfBoundsException f){
			firstScoreLabel = new JLabel("1. -", JLabel.CENTER);
		}	

	        try{
			secondScoreLabel = new JLabel(("2. " + Integer.toString(hsm.showHighScore().get(1))), JLabel.CENTER );
	       }
	       catch(NullPointerException e) {
	       		secondScoreLabel = new JLabel("2. -", JLabel.CENTER);
	       }
	       	catch(IndexOutOfBoundsException f){
			secondScoreLabel = new JLabel("2. -", JLabel.CENTER);
		}	
	       
	        try{
			thirdScoreLabel = new JLabel(("3. " + Integer.toString(hsm.showHighScore().get(2))), JLabel.CENTER );
	       }
	       catch(NullPointerException e) {
	       		thirdScoreLabel = new JLabel("3. -", JLabel.CENTER);
	       }
	       	catch(IndexOutOfBoundsException f){
			thirdScoreLabel = new JLabel("3. -", JLabel.CENTER);
		}	
	       
	        try{
			fourthScoreLabel = new JLabel(("4. " + Integer.toString(hsm.showHighScore().get(3))), JLabel.CENTER );
	       }
	       catch(NullPointerException e) {
	       		fourthScoreLabel = new JLabel("4. -", JLabel.CENTER);
	       }
	       	catch(IndexOutOfBoundsException f){
			fourthScoreLabel = new JLabel("4. -", JLabel.CENTER);
		}	
	       
	        try{	
			fifthScoreLabel = new JLabel(("5. " + Integer.toString(hsm.showHighScore().get(4))), JLabel.CENTER );
	       }
	       catch(NullPointerException e) {
	       		fifthScoreLabel = new JLabel("5. -", JLabel.CENTER);
	       }
	       	catch(IndexOutOfBoundsException f){
			fifthScoreLabel = new JLabel("5. -", JLabel.CENTER);
		}

		firstScoreLabel.setOpaque(true);
		firstScoreLabel.setFont(this.buttonFont);
		firstScoreLabel.setForeground(Color.RED);
		firstScoreLabel.setBackground(Color.BLACK);
		firstScoreLabel.setSize(250,100);
		firstScoreLabel.setLocation(180,150);

		secondScoreLabel.setOpaque(true);
		secondScoreLabel.setFont(this.buttonFont);
		secondScoreLabel.setForeground(Color.RED);
		secondScoreLabel.setBackground(Color.BLACK);
		secondScoreLabel.setSize(250,100);
		secondScoreLabel.setLocation(180,240);

		thirdScoreLabel.setOpaque(true);
		thirdScoreLabel.setFont(this.buttonFont);
		thirdScoreLabel.setForeground(Color.RED);
		thirdScoreLabel.setBackground(Color.BLACK);
		thirdScoreLabel.setSize(250,100);
		thirdScoreLabel.setLocation(180,330);

		fourthScoreLabel.setOpaque(true);
		fourthScoreLabel.setFont(this.buttonFont);
		fourthScoreLabel.setForeground(Color.RED);
		fourthScoreLabel.setBackground(Color.BLACK);
		fourthScoreLabel.setSize(250,100);
		fourthScoreLabel.setLocation(180,420);

		fifthScoreLabel.setOpaque(true);
		fifthScoreLabel.setFont(this.buttonFont);
		fifthScoreLabel.setForeground(Color.RED);
		fifthScoreLabel.setBackground(Color.BLACK);
		fifthScoreLabel.setSize(250,100);
		fifthScoreLabel.setLocation(180,510);

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
		backToMain.setLocation(25,610);
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
