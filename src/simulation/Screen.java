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
        
        int[] changeValues = new int[1000];
        changeValues[0] = Main.changeValues.get(0);
        for (int p = 0; p < Main.changeValues.size(); p++){
            changeValues[p] = Main.changeValues.get(p);
        }
        
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        
        boolean isItPrinting = false;
        if(Printer.isPrinting()) {
            isItPrinting = true;
        }
        
        try {
            img = ImageIO.read(new File("../img/Quadcopter.png"));
        }
        catch (IOException e) { }
        
        g.drawImage(img, x-25, y-25, null); //Draws image at necessary point
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("../Desktop/simulation/Quadcopter50x50.png"));
        } catch (IOException e) {
        }
        g.drawImage(img, x-25, y-25, null);//Draws image at necessary point
                int changeValuesSize = Main.changeValues.size();
        
        if (Main.numTick > ((changeValuesSize)/3)){
            int go = 0;
            while (go < (changeValuesSize-((changeValuesSize/3)))){
                g.drawLine(changeValues[go]+initX-10, changeValues[go+1]+initY-10, changeValues[go+3]+initX-10, changeValues[go+4]+initY-10);
                go += 3;
            }
        }
    }
}