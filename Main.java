package simulation;

import javax.swing.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> lineArray = new ArrayList<String>();
        lineArray = read();
        
        
        JFrame f = new JFrame("Quadcopter Stimulation");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 1000);
		System.out.println("Welcome to the stimulation");
        setup();
        int i = 0;
        int j = 0;
        while(i <= 20) {
            String aString = lineArray.get(i);
            System.out.println("ASTRING" + aString);
            String[] aStringSplitted = aString.split(" ");
            System.out.println("aStringSplitted Number One  " + aStringSplitted[0]);
            while (j < 4){
                String bString = aStringSplitted[j];
                int final = Integer.parseInt(bString);
                System.out.println(final);
                j++;
            }
            tick(f);
            i += 1;
        }
	}
    
    public static ArrayList<String> read() throws FileNotFoundException{
        String sentence = "test";
        ArrayList<String> lineArray = new ArrayList<String>();
        Scanner fileScan;
        int x=0;
        //String aString = "test";
        fileScan = new Scanner (new File("Change.txt"));
        while(fileScan.hasNext()){
            sentence = fileScan.nextLine();
            System.out.println("SENTENCE:" + sentence);
            lineArray.add(sentence);
        }
        //System.out.println(lineArray[1]);
        return lineArray;
    }
    
    public static void tick(JFrame f) {
        
        Quadcopter.RPM1();
        Quadcopter.RPM2();
        Quadcopter.RPM3();
        Quadcopter.RPM4();
        Quadcopter.changeX(Quadcopter.RPM1, Quadcopter.RPM2, Quadcopter.RPM3, Quadcopter.RPM4);
        Quadcopter.changeY(Quadcopter.RPM1, Quadcopter.RPM2, Quadcopter.RPM3, Quadcopter.RPM4);
        Quadcopter.changeZ(Quadcopter.RPM1, Quadcopter.RPM2, Quadcopter.RPM3, Quadcopter.RPM4);
        Quadcopter.posZ();
        Quadcopter.isFlying(Quadcopter.posZ);
        Screen s = new Screen();
        f.add(s);
        f.setVisible(true);
        System.out.println(Quadcopter.posX + "x, " + Quadcopter.posY + "y, " + Quadcopter.posZ + "z");
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
    }
    
    public static void setup() {
        
        Quadcopter.RPM1 = 0;
        Quadcopter.RPM2 = 0;
        Quadcopter.RPM3 = 0;
        Quadcopter.RPM4 = 0;
        Quadcopter.posX = 0;
        Quadcopter.posY = 0;
        Quadcopter.posZ = 0;
        Quadcopter.isFlying(Quadcopter.posZ);
    }
    
}