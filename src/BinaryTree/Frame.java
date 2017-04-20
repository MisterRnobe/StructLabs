package BinaryTree;

import javax.swing.*;

/**
 * Created by Dell on 20.04.2017.
 */
class Frame extends JFrame {
    Frame(BinaryTree<?,?> o)
    {
        super();
        this.setContentPane(new Panel(o));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1000,500);
        this.setVisible(true);
    }
}
