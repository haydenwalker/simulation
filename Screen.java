package simulation;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Screen extends JPanel {
    
    public int x = Quadcopter.posX();
    public int y = Quadcopter.posY();
    public int size = (10000/(500-Quadcopter.posZ()));
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        g.fillRect((x + 250), (y + 250), size, size);
        
    }

}