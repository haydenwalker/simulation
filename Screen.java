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

public class Screen extends JPanel{
    
    static int initX = 100;
    static int initY = 100;

    
    public int x = Quadcopter.posX() + initX;
    public int y = Quadcopter.posY() + initY;
    public int size = (10000/(500-Quadcopter.posZ()));
    public void paintComponent(Graphics g){
        int prevX = 100;
        int prevY = 100;
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
            img = ImageIO.read(new File("../Documents/simulation/Quadcopter.png"));
        } catch (IOException e) {
        }
        g.drawImage(img, x-30, y-30, null);//Draws image at necessary point
        
        System.out.println("QPX" + Quadcopter.posX);

        g.drawLine(initX, initY, x, y);
        Main.positions[Main.currentScreenThread] = x;
        Main.positions[Main.currentScreenThread+1] = y;
        
        int[] changeValues = new int[100];
        changeValues[0] = Main.changeValues.get(0);
        for (int p = 0; p < Main.changeValues.size(); p++){
            changeValues[p] = Main.changeValues.get(p);
        }
        for (int p = 0; p < 100; p++){
            System.out.println("changeAt" +p + " "+ changeValues[p]);
        }
        /*
        for (int p = 0; p<26; p+=3){
            g.drawLine(changeValues[p]+30, changeValues[p+1]+30, changeValues[p+3], changeValues[p+4]);
        }
         */
        
        
        
        Main.currentScreenThread += 1;
    }

}