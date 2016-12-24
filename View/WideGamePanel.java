
package View;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MSI on 24.12.2016.
 */

public class WideGamePanel extends JPanel {

    private JSplitPane splitPane;
    private JPanel gamePanel;
    private JPanel scorePanel;

    public WideGamePanel() {
        this.setPreferredSize(new Dimension(750, 800));
        this.setLayout(new FlowLayout());
        this.setBackground(Color.GRAY);
        /*
        this.gamePanel = MainFrame.getInstance().getGamePanel();
        this.scorePanel = MainFrame.getInstance().getScorePanel();

        //this.splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, gamePanel, scorePanel);

        //this.add(splitPane);
        this.add(this.gamePanel);
        this.add(this.scorePanel);
        */
        this.setFocusable(true);
        this.requestFocusInWindow(true);
    }
}

    /*
    public JPanel gamePanel;
    JPanel scorePanel;

    public WideGamePanel(){
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(750, 800));
        this.setLayout(new FlowLayout());

        this.gamePanel = new GamePanel();
        this.scorePanel = new ScorePanel();
        this.add(gamePanel);
        this.add(scorePanel);
        this.setFocusable(true);
        this.requestFocusInWindow(true);
    }

    JPanel getGamePanel() {return this.gamePanel;}

    public void draw(int[][] intmap) {
        this.gamePanel.draw(intmap);
    }
    */
//}
