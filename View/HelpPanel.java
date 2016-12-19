package View;

import static java.awt.Font.createFont;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.*;

public class HelpPanel extends JPanel {
	private Font customFont;
    private Font buttonFont;
    private Font hoverFont;
    private MenuListener menuListener;
    
    public HelpPanel(){
    	this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setLayout(null);
        menuListener = new MenuListener();
        
        try {
            this.customFont = createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")).deriveFont(70f);
            this.buttonFont = customFont.deriveFont(30f);
            this.hoverFont = customFont.deriveFont(33f);
            //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")));
        }
        catch (IOException e) {
            this.customFont = new Font("Century", 1, 20);
            this.buttonFont = new Font("Century", 1, 20);
        }
        catch (FontFormatException e) {
            this.customFont = new Font("Century", 1, 20);
            this.buttonFont = new Font("Century", 1, 20);
        }
        
        //NameLabel : HELP
        JLabel nameLabel = new JLabel("HELP", JLabel.CENTER);
        nameLabel.setOpaque(true);
        nameLabel.setFont(this.customFont);
        nameLabel.setForeground(Color.RED);
        nameLabel.setBackground(Color.BLACK);
        nameLabel.setSize(450,150);
        nameLabel.setLocation(265,30);
        this.add(nameLabel);
        
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
    	
    	private MenuListener(){
    		
    	}

		@Override
		public void actionPerformed(ActionEvent event) {
			
			String str;
			Object obj = event.getSource();
			switch (str = ((JButton)obj).getText()){
				case "Back":{
                    MainFrame.getInstance().changeCase(0, 1);
                    break;
				}
			}
    	}
	}
}