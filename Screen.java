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
        
        int[] changeValues = new int[100];
        changeValues[0] = Main.changeValues.get(0);
        for (int p = 0; p < Main.changeValues.size(); p++){
            changeValues[p] = Main.changeValues.get(p);
        }
        System.out.printf("changeAt[");
        for (int p = 0; p < Main.changeValues.size(); p++){
            System.out.printf(changeValues[p] + ", ");
        }
        System.out.printf("]\n");
        
        int prevX = 100;
        int prevY = 100;
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        
        boolean isItPrinting = false;
        if(Printer.isPrinting()) {
            isItPrinting = true;
        }
        BufferedImage img = null;         try {
            img = ImageIO.read(new File("../Desktop/simulation/Quadcopter50x50.png"));
        } catch (IOException e) {
        }
        g.drawImage(img, x-25, y-25, null);//Draws image at necessary point
        
        if (Main.numTick > (Main.changeValues.size())/3){
            g.drawLine(changeValues[0]+initX-10, changeValues[1]+initY-10, changeValues[3]+initX-10, changeValues[4]+initY-10);
            
            g.drawLine(changeValues[3]+initX-10, changeValues[4]+initY-10, changeValues[6]+initX-10, changeValues[7]+initY-10);
        
            g.drawLine(changeValues[6]+initX-10, changeValues[7]+initY-10, changeValues[9]+initX-10, changeValues[10]+initY-10);
            
            g.drawLine(changeValues[9]+initX-10, changeValues[10]+initY-10, changeValues[12]+initX-10, changeValues[13]+initY-10);
            
            g.drawLine(changeValues[12]+initX-10, changeValues[13]+initY-10, changeValues[15]+initX-10, changeValues[16]+initY-10);
            
            g.drawLine(changeValues[15]+initX-10, changeValues[16]+initY-10, changeValues[18]+initX-10, changeValues[19]+initY-10);
            
            g.drawLine(changeValues[18]+initX-10, changeValues[19]+initY-10, changeValues[21]+initX-10, changeValues[22]+initY-10);
            
            g.drawLine(changeValues[21]+initX-10, changeValues[22]+initY-10, changeValues[24]+initX-10, changeValues[25]+initY-10);
            
            g.drawLine(changeValues[24]+initX-10, changeValues[25]+initY-10, changeValues[27]+initX-10, changeValues[28]+initY-10);
            
            g.drawLine(changeValues[27]+initX-10, changeValues[28]+initY-10, changeValues[30]+initX-10, changeValues[31]+initY-10);
            
            g.drawLine(changeValues[30]+initX-10, changeValues[31]+initY-10, changeValues[33]+initX-10, changeValues[34]+initY-10);
            
            g.drawLine(changeValues[33]+initX-10, changeValues[34]+initY-10, changeValues[36]+initX-10, changeValues[37]+initY-10);
            
            g.drawLine(changeValues[36]+initX-10, changeValues[37]+initY-10, changeValues[39]+initX-10, changeValues[40]+initY-10);
            
            g.drawLine(changeValues[39]+initX-10, changeValues[40]+initY-10, changeValues[42]+initX-10, changeValues[43]+initY-10);
        }
        
    }

}