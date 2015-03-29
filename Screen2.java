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

    public int x = 1;
    public int y = 1;
    public int size = 1000;
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);

        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("../img/Quadcopter.png"));
        }

        catch (IOException e) { }

        g.drawImage(img, x-25, y-25, null); //Draws image at necessary point
    }
}
