package simulation;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Screen2 extends JPanel{

    public int x = Quadcopter.posX;
    public int y = Quadcopter.posY;
    public int size = 1000;
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);

        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("../img/Side.png"));
        }

        catch (IOException e) { }

        g.drawLine(0, 250, 300, 250);
        g.drawImage(img, Quadcopter.posX, Quadcopter.posZ+110, null); //Draws image at necessary point
    }
}
