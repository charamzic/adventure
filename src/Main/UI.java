package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {

    Game gm;
    JFrame window;
    public JTextArea narrator;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(Game gm) {
        this.gm = gm;

        createMainField();
        createBackground();
        createObject(300, 150, 90, 150, "guard.png");

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        narrator = new JTextArea("Tak tohle bude nejprisnejsi klikacka efffer");
        narrator.setBounds(50, 410, 700, 150);
        narrator.setBackground(Color.BLACK);
        narrator.setForeground(Color.WHITE);
        narrator.setEditable(false);
        narrator.setLineWrap(true);
        narrator.setWrapStyleWord(true);
        narrator.setFont(new Font("Didot", Font.PLAIN, 26));
        window.add(narrator);
    }

    public void createBackground() {
        bgPanel[1] = new JPanel();
        bgPanel[1].setBounds(50, 50, 700, 350);
        bgPanel[1].setBackground(null);
        bgPanel[1].setLayout(null);
        window.add(bgPanel[1]);

        bgLabel[1] = new JLabel();
        bgLabel[1].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("paloucek.png"));
        bgLabel[1].setIcon(bgIcon);

    }

    public void createObject(int objX, int objY, int objWidth, int objHeight, String objFileName) {
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objX, objY, objWidth, objHeight);

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));

        objectLabel.setIcon(objectIcon);

        bgPanel[1].add(objectLabel);
        bgPanel[1].add(bgLabel[1]);
    }
}
