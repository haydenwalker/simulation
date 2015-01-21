package simulation;

import javax.swing.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Stack;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;

public class Main {
	
    
	public static void main(String[] args) throws FileNotFoundException {

        //Opens JFrame
        JFrame f = new JFrame("Quadcopter Stimulation");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 1000);
        System.out.println("Welcome to the stimulation");
        setup();
        
        List<Integer> changeValues = new ArrayList<Integer>();
        changeValues = getValues();
        
        
        int lineArraySize = changeValues.size() / 3;
        for (int n = lineArraySize; n >= 0; n--){
            tick(f);
        }
        
            
	}
    
    public static ArrayList<Integer> getValues() throws FileNotFoundException{
        ArrayList<String> lineArray = new ArrayList<String>(); //lineArray holds all values in text file, lines separated by commas
        lineArray = read(); //uses read method to fetch data from text file
        int bStringParsed = 0; //holds the value of bString after it is parsed
        int lineArraySize = lineArray.size();
        int numValues = lineArraySize * 3;
        ArrayList<Integer> changeValues = new ArrayList<Integer>(); // New ArrayList of Integers, used to store all integer values in text file, in order.
        System.out.println("LINEARRAYSIZE" + lineArraySize);
        
        int i = 0;
        int j = 0;
        int h = 0;
        while(i <= (lineArraySize-1)) { //Takes in 4 lines from the text file. Can be raised if necessary.
            String aString = lineArray.get(i); //String aString holds the string at point i in the ArrayList<String> lineArray
            String[] aStringSplitted = aString.split(" ");//String Array aStringSplitted holds each of the three values on each line in the text file. These values, though numbers, are stored as string values.
            while (j < 3){ //So this while loop parses the values into integers and stores the new values in a new
                String bString = aStringSplitted[j]; //String bString stores the value of aStringSplitted at point j
                bStringParsed = Integer.parseInt(bString);
                System.out.println("bStringParsedTest" + bStringParsed);
                changeValues.add(bStringParsed);
                j++;
                h++;
            }
            j = 0;
            i += 1;
            h++;
        }
        i = 0;
        return changeValues;
    }
    
    public static ArrayList<String> read() throws FileNotFoundException{ //Returns value of type ArrayList<String>
        String sentence = "test"; //sentence used to hold each line
        ArrayList<String> lineArray = new ArrayList<String>();
        Scanner fileScan;
        int x=0;
        fileScan = new Scanner (new File("../Desktop/simulation/Change.txt"));
        while(fileScan.hasNext()){
            sentence = fileScan.nextLine();
            lineArray.add(sentence); // add() appends each line to lineArray
        }
        return lineArray;
    }
    public static int k = 0;
    public static void tick(JFrame f) throws FileNotFoundException {
        
        List<Integer> changeValues = new ArrayList<Integer>();
        changeValues = getValues();
        
        Quadcopter.RPM1();
        Quadcopter.RPM2();
        Quadcopter.RPM3();
        Quadcopter.RPM4();
        Quadcopter.changeX(Quadcopter.RPM1, Quadcopter.RPM2, Quadcopter.RPM3, Quadcopter.RPM4);
        Quadcopter.changeY(Quadcopter.RPM1, Quadcopter.RPM2, Quadcopter.RPM3, Quadcopter.RPM4);
        Quadcopter.changeZ(Quadcopter.RPM1, Quadcopter.RPM2, Quadcopter.RPM3, Quadcopter.RPM4);
        Quadcopter.posZ();
        Quadcopter.isFlying(Quadcopter.posZ);
        if (Quadcopter.posZ > 3){ //Makes sure it doesn't fly up out of screen (Gravity?)
            Quadcopter.posZ -= 1;
        }
        
        Quadcopter.changeX = changeValues.get(k);
        Quadcopter.changeY = changeValues.get(k+1);
        //Quadcopter.chanzeZ = changeValues.get(k+2);
        
        Screen s = new Screen();
        f.add(s);
        f.setVisible(true);
        System.out.println(Quadcopter.posX + "x, " + Quadcopter.posY + "y, " + Quadcopter.posZ + "z");
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (k < changeValues.size() - 3){
            k += 3;
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