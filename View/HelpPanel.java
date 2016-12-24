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

public class HelpPanel extends JPanel {
	private Font customFont;
    private Font buttonFont;
    private Font hoverFont;
    private MenuListener menuListener;
    private BufferedImage keybordImage;
    private BufferedImage spaceButton;
    
    public HelpPanel(){
    	this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(750, 800));
        this.setLayout(null);
        menuListener = new MenuListener();
        
        try {
            this.customFont = createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")).deriveFont(70f);
            this.buttonFont = customFont.deriveFont(27f);
            this.hoverFont = customFont.deriveFont(30f);
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
            this.keybordImage = ImageIO.read(new File("Resources/ArrowKeys.png"));
            this.spaceButton = ImageIO.read(new File("Resources/spaceButton.png"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
        //NameLabel : HELP
        JLabel nameLabel = new JLabel("HELP", JLabel.CENTER);
        nameLabel.setOpaque(true);
        nameLabel.setFont(this.customFont);
        nameLabel.setForeground(Color.RED);
        nameLabel.setBackground(Color.BLACK);
        nameLabel.setSize(400,150);
        nameLabel.setLocation(180,30);
        this.add(nameLabel);
        
        JLabel moveLabel = new JLabel("Movement", JLabel.CENTER);
        moveLabel.setOpaque(true);
        moveLabel.setFont(this.buttonFont);
        moveLabel.setForeground(Color.RED);
        moveLabel.setBackground(Color.BLACK);
        moveLabel.setSize(200,30);
        moveLabel.setLocation(100,450);
        this.add(moveLabel);
        
        JLabel shootLabel = new JLabel("Attack", JLabel.CENTER);
        shootLabel.setOpaque(true);
        shootLabel.setFont(this.buttonFont);
        shootLabel.setForeground(Color.RED);
        shootLabel.setBackground(Color.BLACK);
        shootLabel.setSize(200,30);
        shootLabel.setLocation(75,650);
        this.add(shootLabel);
        
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
    
    public void paintComponent(Graphics g){
    	   super.paintComponent(g);

           Graphics2D g2d = (Graphics2D) g.create();
           int xCoordinate = 0;
           int yCoordinate = 0;
        		   
           g2d.drawImage(this.keybordImage, (100  ), (220 ), 200, 200, Color.black, null);
           g2d.drawImage(this.spaceButton, (100  ), (510 ), 400, 100, Color.black, null);
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