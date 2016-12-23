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

import javax.imageio.ImageIO;
import javax.swing.*;

public class SettingsPanel extends JPanel {
	
	private BufferedImage openSoundBar;
	private BufferedImage closeSoundBar;
	
	private Font customFont;
    private Font buttonFont;
    private Font hoverFont;
    private MenuListener menuListener;
	public SettingsPanel(){
		
	    this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(750, 800));
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
		
	    try {
            this.openSoundBar = ImageIO.read(new File("Resources/playerTankU.png"));
            this.closeSoundBar = ImageIO.read(new File("Resources/playerTankU.png"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
	    
	    //NameLabel: Settings
	    JLabel nameLabel = new JLabel("SETTINGS", JLabel.CENTER);
        nameLabel.setOpaque(true);
        nameLabel.setFont(this.customFont);
        nameLabel.setForeground(Color.RED);
        nameLabel.setBackground(Color.BLACK);
        nameLabel.setSize(440,150);
        nameLabel.setLocation(160,30);
        this.add(nameLabel);
        

	    //NameLabel: ChangeLevel
	    JLabel changeLevelLabel = new JLabel("CHANGE LEVEL", JLabel.CENTER);
	    changeLevelLabel.setOpaque(true);
	    changeLevelLabel.setFont(this.buttonFont);
	    changeLevelLabel.setForeground(Color.RED);
	    changeLevelLabel.setBackground(Color.BLACK);
	    changeLevelLabel.setSize(450,150);
	    changeLevelLabel.setLocation(160,150);
        this.add(changeLevelLabel);
        
        //Buttons
        //Level1 Button
        JButton level1Button = new JButton("1");
        level1Button.setFont(this.buttonFont);
        level1Button.setSize( 150, 100 );
        this.add(level1Button);
        level1Button.setLocation(300,270);
        level1Button.setOpaque(false);
        level1Button.setContentAreaFilled(false);
        level1Button.setBorderPainted(false);
        level1Button.setForeground(Color.RED);
        level1Button.addActionListener(menuListener);
        level1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
            	level1Button.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	level1Button.setFont(buttonFont);
            }

        });
        
        //level 2 button
        JButton level2Button = new JButton("2");
        level2Button.setFont(this.buttonFont);
        level2Button.setSize( 150, 100 );
        this.add(level2Button);
        level2Button.setLocation(300,330);
        level2Button.setOpaque(false);
        level2Button.setContentAreaFilled(false);
        level2Button.setBorderPainted(false);
        level2Button.setForeground(Color.RED);
        level2Button.addActionListener(menuListener);
        level2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
            	level2Button.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	level2Button.setFont(buttonFont);
            }

        });
        
        //level 3 button
        JButton level3Button = new JButton("3");
        level3Button.setFont(this.buttonFont);
        level3Button.setSize( 150, 100 );
        this.add(level3Button);
        level3Button.setLocation(300,390);
        level3Button.setOpaque(false);
        level3Button.setContentAreaFilled(false);
        level3Button.setBorderPainted(false);
        level3Button.setForeground(Color.RED);
        level3Button.addActionListener(menuListener);
        level3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
            	level3Button.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	level3Button.setFont(buttonFont);
            }

        });
        
        //level 4 button
        JButton level4Button = new JButton("4");
        level4Button.setFont(this.buttonFont);
        level4Button.setSize( 150, 100 );
        this.add(level4Button);
        level4Button.setLocation(300,450);
        level4Button.setOpaque(false);
        level4Button.setContentAreaFilled(false);
        level4Button.setBorderPainted(false);
        level4Button.setForeground(Color.RED);
        level4Button.addActionListener(menuListener);
        level4Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
            	level4Button.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	level4Button.setFont(buttonFont);
            }

        });
        
        //level 5 button
        JButton level5Button = new JButton("5");
        level5Button.setFont(this.buttonFont);
        level5Button.setSize( 150, 100 );
        this.add(level5Button);
        level5Button.setLocation(300,510);
        level5Button.setOpaque(false);
        level5Button.setContentAreaFilled(false);
        level5Button.setBorderPainted(false);
        level5Button.setForeground(Color.RED);
        level5Button.addActionListener(menuListener);
        level5Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
            	level5Button.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	level5Button.setFont(buttonFont);
            }

        });
        //NameLabel: Change Volume
	    JLabel changeVolumeLable = new JLabel("CHANGE VOLUME", JLabel.CENTER);
	    changeVolumeLable.setOpaque(true);
	    changeVolumeLable.setFont(this.buttonFont);
	    changeVolumeLable.setForeground(Color.RED);
	    changeVolumeLable.setBackground(Color.BLACK);
	    changeVolumeLable.setSize(450,150);
	    changeVolumeLable.setLocation(160,570);
        this.add(changeVolumeLable);
        
        //Back to main menu button
        JButton backToMain = new JButton("Back");
        backToMain.setFont(this.buttonFont);
        backToMain.setSize( 200, 200 );
        this.add(backToMain);
        backToMain.setLocation(25,650);
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
				case "1":{
                    MainFrame.getInstance().changeCase(2, 1);
                    break;
				}
				case "2":{
                    MainFrame.getInstance().changeCase(2, 2);
                    break;
				}
				case "3":{
					MainFrame.getInstance().changeCase(2, 3);
                    break;
				}
				case "4":{
					MainFrame.getInstance().changeCase(2, 4);
                    break;
				}
				case "5":{
					MainFrame.getInstance().changeCase(2, 5);
                    break;
				}
				case "Back":{
					MainFrame.getInstance().changeCase(0, 1);
					break;
				}
			}
			
		}
    	
    }
}