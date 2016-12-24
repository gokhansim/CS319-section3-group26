package View;

import javafx.scene.layout.BorderRepeat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.createFont;

/**
 * Created by MSI on 24.12.2016.
 */

public class ScorePanel extends JPanel {
    private Font customFont;
    private Font buttonFont;
    private Font hoverFont;
    JLabel scoreLabel;
    JLabel lifeLabel;

    public ScorePanel(){
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(750, 50));
        this.setLayout(new GridLayout(1,4));

        this.setFocusable(true);
        this.requestFocusInWindow(true);

        try {
            this.customFont = createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")).deriveFont(15f);
            this.buttonFont = customFont.deriveFont(15f);
            this.hoverFont = customFont.deriveFont(16f);
            //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Resources/WeekendWarrior.ttf")));
        }
        catch (IOException e) {
            this.customFont = new Font("Century", 1, 20);
        }
        catch (FontFormatException e) {
            this.customFont = new Font("Century", 1, 20);
        }

        scoreLabel = new JLabel("score:", JLabel.CENTER);
        scoreLabel.setFont(this.customFont);
        scoreLabel.setOpaque(true);
        scoreLabel.setForeground(Color.RED);
        scoreLabel.setBackground(Color.BLACK);
        this.add(scoreLabel);

        lifeLabel = new JLabel("lives:", JLabel.CENTER);
        lifeLabel.setFont(this.customFont);
        lifeLabel.setOpaque(true);
        lifeLabel.setForeground(Color.RED);
        lifeLabel.setBackground(Color.BLACK);
        this.add(lifeLabel);

        JButton backToMain = new JButton("pause");
        this.add(backToMain);
        backToMain.setFont(this.customFont);
        // backToMain.addActionListener(menuListener);
        backToMain.setOpaque(false);
        backToMain.setContentAreaFilled(false);
        backToMain.setBorderPainted(false);
        backToMain.setForeground(Color.RED);
        backToMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                backToMain.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backToMain.setFont(buttonFont);
            }
        });
        backToMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().changeCase(8, 1);
            }
        } );

        JButton resumeButton = new JButton("resume");
        this.add(resumeButton);
        resumeButton.setFont(this.customFont);
        // backToMain.addActionListener(menuListener);
        resumeButton.setOpaque(false);
        resumeButton.setContentAreaFilled(false);
        resumeButton.setBorderPainted(false);
        resumeButton.setForeground(Color.RED);
        resumeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                resumeButton.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resumeButton.setFont(buttonFont);
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().changeCase(8, 2);
            }
        } );

        JButton backButton = new JButton("back");
        this.add(backButton);
        backButton.setFont(this.customFont);
        // backToMain.addActionListener(menuListener);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.RED);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                backButton.setFont(hoverFont);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setFont(buttonFont);
            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().changeCase(0, 2);
            }
        } );


    }

    public void updateScore( int score){
        this.scoreLabel.setText("score: " + String.valueOf(score));
    }

    public void updateLives( int remainingLives){
        this.lifeLabel.setText("lives: " + String.valueOf(remainingLives));
    }
}
