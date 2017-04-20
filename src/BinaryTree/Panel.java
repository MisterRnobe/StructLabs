package BinaryTree;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Dell on 20.04.2017.
 */
public class Panel extends JPanel {
    private BinaryTree<?,?> tree;
    public Panel(BinaryTree<?,?> tree)
    {
        super();
        this.tree = tree;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        drawTree(g, tree.root(),0, this.getWidth(), 20);
    }
    private Dimension drawTree(Graphics g, Node<?,?> node, int fromX, int toX, int y)
    {
        Dimension dim;
        int width = toX-fromX;
        if (node.getRight()!=0)
        {
            dim = drawTree(g, node.getRightNode(), fromX + width/2, toX, y + 40);
            g.drawLine(fromX + width/2, y, (int)dim.getWidth(), (int)dim.getHeight());
        }
        g.drawRect(fromX + width/4, y, width/2, 20);
        g.drawString(node.toString(), fromX + width/2, y+20);

        if (node.getLeft() != 0)
        {
            dim = drawTree(g, node.getLeftNode(), fromX, fromX + width/2, y + 40);
            g.drawLine(fromX + width/2, y, (int)dim.getWidth(), (int)dim.getHeight());
        }
        return new Dimension(fromX + width/2, y);
    }
}
