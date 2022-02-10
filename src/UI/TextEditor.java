package UI;

import javax.swing.*;

public class TextEditor extends JFrame {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JFrame frame;

    public TextEditor(){
        initComponents();
    }

    public void initComponents(){
        this.setTitle("Editor de texto todo feo ._ .");
        this.setResizable(false);
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TextEditor();
    }

}
