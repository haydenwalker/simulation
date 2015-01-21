package simulation;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Screen extends JPanel {
    
    int initX = 100;
    int initY = 100;
    
    public int x = Quadcopter.posX() + initX;
    public int y = Quadcopter.posY() + initY;
    public int size = (10000/(500-Quadcopter.posZ()));
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        //g.fillRect(x-(size/2), y-(size/2), size, size);
        boolean isItPrinting = false;
        if(Printer.isPrinting()) {
            isItPrinting = true;
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("../Desktop/simulation/Quadcopter50x50.png"));
        } catch (IOException e) {
        }
        g.drawImage(img, x-30, y-30, null);//Draws image at necessary point
        
        //g.drawLine(10, 10, 250 + ((1/2) * size), 250 + ((1/2) * size));
        g.drawLine(initX, initY, x + ((1/2) * size), y + ((1/2) * size));
    }

}