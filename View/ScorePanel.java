package View;

import javafx.scene.layout.BorderRepeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.setLayout(new BorderLayout());

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
        this.add(scoreLabel, BorderLayout.WEST);

        lifeLabel = new JLabel("remaining lives:", JLabel.CENTER);
        lifeLabel.setFont(this.customFont);
        lifeLabel.setOpaque(true);
        lifeLabel.setForeground(Color.RED);
        lifeLabel.setBackground(Color.BLACK);
        this.add(lifeLabel, BorderLayout.CENTER);

        JButton backToMain = new JButton("Back");
        this.add(backToMain, BorderLayout.EAST);
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

                MainFrame.getInstance().changeCase(0, 1);
            }
        } );
    }

    public void updateScore( int score){
        this.scoreLabel.setText("score: " + String.valueOf(score));
    }

    public void updateLives( int remainingLives){
        this.lifeLabel.setText("remaining lives: " + String.valueOf(remainingLives));
    }
}
