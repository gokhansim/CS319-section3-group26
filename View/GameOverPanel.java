package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.createFont;

public class GameOverPanel extends JPanel {

    private Font customFont;
    private Font buttonFont;
    private Font hoverFont;
    private MenuListener menuListener;

    public GameOverPanel(){
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(750, 800));
        this.setLayout(null);
        this.setMaximumSize(this.getPreferredSize());
        // this.addKeyListener(new GamePanel.KeyboardListener());
        this.setFocusable(true);
        this.requestFocusInWindow(true);
        menuListener = new MenuListener();

        // Customizing Font
        try {
            this.customFont = createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")).deriveFont(70f);
            this.buttonFont = customFont.deriveFont(24f);
            this.hoverFont = customFont.deriveFont(27f);
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

        JLabel overLabel = new JLabel("GAME OVER", JLabel.CENTER);
        overLabel.setOpaque(true);
        overLabel.setFont(this.customFont);
        overLabel.setForeground(Color.RED);
        overLabel.setBackground(Color.BLACK);
        overLabel.setSize(600,150);
        overLabel.setLocation(80,250);
        this.add(overLabel);

        // BUTTONS
        // Back to Main Menu Button
        JButton playButton = new JButton("Main Menu");
        playButton.setFont(this.buttonFont);
        playButton.setSize( 300, 200 );
        this.add(playButton);
        playButton.setLocation(110,330);
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
        // Back to Main Menu Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(this.buttonFont);
        exitButton.setSize( 300, 200 );
        this.add(exitButton);
        exitButton.setLocation(370,330);
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

    private class MenuListener implements ActionListener {
        private MenuListener() {
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            String str;
            Object obj = event.getSource();
            switch (str = ((JButton)obj).getText()) {
                case "Main Menu": {
                    MainFrame.getInstance().changeCase(0,1);
                    break;
                }
                case "Exit":{
                    MainFrame.getInstance().changeCase(5, 1);
                    break;
                }
            }
        }
    }
}
