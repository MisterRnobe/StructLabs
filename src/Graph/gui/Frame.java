package Graph.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dell on 16.05.2017.
 */
public class Frame extends JFrame {
    public static final int MAX_SIZE = 11;
    public Frame()
    {
        super("Graph");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setSize(1000,1000);
        addPanels();
        this.pack();
        this.setVisible(true);

    }
    private void addPanels()
    {
        Container panel = this.getContentPane();

        panel.add(new ControlPanel(), BorderLayout.NORTH);

        JPanel jPanel = new JPanel();

        jPanel.add(new InputPanel(3));
        jPanel.add(new OutputPanel());

        panel.add(jPanel, BorderLayout.CENTER);
    }
}
