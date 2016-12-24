package View;

import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.createFont;

public class MainMenuPanel extends JPanel{

    private BufferedImage playerTank;
    private BufferedImage playerTank2;
    private Font customFont;
    private Font buttonFont;
    private Font hoverFont;
    MenuListener menuListener;

    public MainMenuPanel( ) {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1200, 1000));
        this.setPreferredSize(new Dimension(750, 800));
        this.setLayout(null);
        this.setMaximumSize(this.getPreferredSize());
        this.setFocusable(true);
        this.requestFocusInWindow(true);

        // Customizing Font
        try {
            this.customFont = createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")).deriveFont(100f);
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

        // Getting Image
        try {
            this.playerTank = ImageIO.read(new File("Resources/playerTankU.png"));
            this.playerTank2 = ImageIO.read(new File("Resources/playerTankU.png"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

        menuListener = new MenuListener();

        // NAME LABEL
        JLabel nameLabel = new JLabel("SIEGE", JLabel.CENTER);
        nameLabel.setOpaque(true);
        nameLabel.setFont(this.customFont);
        nameLabel.setForeground(Color.RED);
        nameLabel.setBackground(Color.BLACK);
        nameLabel.setSize(450,150);

        nameLabel.setLocation(150,100);

        nameLabel.setLocation(365,150);
        nameLabel.setLocation(160,100);

        this.add(nameLabel);

        // BUTTONS
        // Play Button
        JButton playButton = new JButton("PLAY");
        playButton.setFont(this.buttonFont);
        playButton.setSize( 150, 100 );
        this.add(playButton);

        playButton.setLocation(300,340);


        playButton.setLocation(520,480);
        playButton.setLocation(310,340);


        playButton.setOpaque(false);
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        playButton.setForeground(Color.RED);
        playButton.addActionListener(menuListener);
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                playButton.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playButton.setFont(buttonFont);
            }

        });
        // Help Button
        JButton helpButton = new JButton("HELP");
        helpButton.setFont(this.buttonFont);
        helpButton.setSize( 150, 100 );
        this.add(helpButton);

        helpButton.setLocation(300,410);


        helpButton.setLocation(520,560);

        helpButton.setLocation(310,410);


        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(false);
        helpButton.setForeground(Color.RED);
        helpButton.addActionListener(menuListener);
        helpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                helpButton.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpButton.setFont(buttonFont);
            }

        });
        // Settings Button
        JButton settingsButton = new JButton("SETTINGS");
        settingsButton.setFont(this.buttonFont);
        settingsButton.setSize( 240, 100 );
        this.add(settingsButton);

        settingsButton.setLocation(257,480);


        settingsButton.setLocation(475,640);

        settingsButton.setLocation(267,480);


        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.setForeground(Color.RED);
        settingsButton.addActionListener(menuListener);
        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                settingsButton.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButton.setFont(buttonFont);
            }

        });
        // High Score Button
        JButton highScoreButton = new JButton("HIGH SCORE");
        highScoreButton.setFont(this.buttonFont);
        highScoreButton.setSize( 300, 100 );
        this.add(highScoreButton);

        highScoreButton.setLocation(224,550);


        highScoreButton.setLocation(224,550);

        highScoreButton.setLocation(445,720);

        highScoreButton.setLocation(237,550);

        highScoreButton.setOpaque(false);
        highScoreButton.setContentAreaFilled(false);
        highScoreButton.setBorderPainted(false);
        highScoreButton.setForeground(Color.RED);
        highScoreButton.addActionListener(menuListener);
        highScoreButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                highScoreButton.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                highScoreButton.setFont(buttonFont);
            }

        });
        // Exit Button
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(this.buttonFont);
        exitButton.setSize( 150, 100 );
        this.add(exitButton);


        exitButton.setLocation(300,620);


        exitButton.setLocation(300,620);

        exitButton.setLocation(518,800);

        exitButton.setLocation(310,620);


        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setForeground(Color.RED);
        exitButton.addActionListener(menuListener);
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                exitButton.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButton.setFont(buttonFont);
            }

        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        int xCoordinate = 0;
        int yCoordinate = 0;


        g2d.drawImage(this.playerTank, (140  ), (480 ), 90, 90, Color.gray, null);
        g2d.drawImage(this.playerTank, (520  ), (480 ), 90, 90, Color.gray, null);

        g2d.drawImage(this.playerTank, (150  ), (480 ), 90, 90, Color.gray, null);
        g2d.drawImage(this.playerTank, (530  ), (480 ), 90, 90, Color.gray, null);


    }

    private class MenuListener implements ActionListener {
        private MenuListener() {
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            String str;
            Object obj = event.getSource();
            switch (str = ((JButton)obj).getText()) {
                case "PLAY": {
                    MainFrame.getInstance().changeCase(1,1);
                    break;
                }
                case "HELP":{
                	MainFrame.getInstance().changeCase(4,1);
                	break;
                }
                case "SETTINGS":{
                	MainFrame.getInstance().changeCase(3,1);
                	break;
                }
                case "HIGH SCORE":{
                	MainFrame.getInstance().changeCase(7,1);
                	break;
                }
                case "EXIT":{
                    MainFrame.getInstance().changeCase(5, 1);
                    break;
                }
            }
        }
    }


}