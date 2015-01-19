package simulation;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Screen extends JPanel {
    
    public int x = Quadcopter.posX() + 250;
    public int y = Quadcopter.posY() + 250;
    public int size = (10000/(500-Quadcopter.posZ()));
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        g.fillRect(x-(size/2), y-(size/2), size, size);
        if(Printer.isPrinting()) {
            g.drawLine(10, 10, x + ((1/2) * size), y + ((1/2) * size));
        }
    }

}