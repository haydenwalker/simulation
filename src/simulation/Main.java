//_____________________________________________________________________________________________________________________________
//
// By Hayden Walker and Connor Bailey
// Renders a JPanel with a simulated quadcopter that flies to specified coordinates and "extrudes" a line behind it.
//
//_____________________________________________________________________________________________________________________________




package simulation;

import javax.swing.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Stack;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Arrays;

public class Main {
	
    public static Scanner start = new Scanner(System.in);
    public static Scanner whatToPrintScanner = new Scanner(System.in);
    public static List<Integer> changeValues = new ArrayList<Integer>();
    public static int numTick = 0;
    public static int whatToPrint;
    public static int lineArraySize;
    
    public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println("What would you like to print?");
        System.out.println("Options: [1] Cube (Isometric Projection)");
        System.out.println("         [2] Triangle");
        System.out.println("         [3] Square");
        System.out.println("         [4] Solid Rectangle");
        System.out.println("         [5] Change.txt (Input your own coordinates to Change.txt)");
        whatToPrint = whatToPrintScanner.nextInt();
        
        char s;
        String inputStart;
        System.out.printf("Start Simulation? y/n: ");
        inputStart = start.nextLine();
        s = inputStart.charAt(0);
        
        if (s == 'y'){
            
            //Opens JFrame
            JFrame f = new JFrame("Quadcopter Stimulation");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(1000, 1000);
            System.out.println("Welcome to the simulation");
            setup();
            
            JFrame z = new JFrame("Up/Down Axis");
            z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            z.setSize(300,300);
            z.setLocationRelativeTo(f);
            
            ArrayList<String> lineArray = new ArrayList<String>(); //lineArray holds all values in text file, lines separated by commas
            lineArray = read(); //uses read method to fetch data from text file
            changeValues = getValues();
            
            lineArraySize = changeValues.size() / 3;
            
            for (int n = lineArraySize; n >= 0; n--){
                tick(f,z);
            }
            
        }
        
        else if (s == 'n'){
            System.out.println("Goodbye");
            System.exit(0);
        }
        
        else{
            System.out.println("Symbol not recognized. Exiting.");
            System.exit(0);
        }
    
	}
    public static ArrayList<Integer> getValues() throws FileNotFoundException{
        ArrayList<String> lineArray = new ArrayList<String>(); //lineArray holds all values in text file, lines separated by commas
        lineArray = read(); //uses read method to fetch data from text file
        int bStringParsed = 0; //holds the value of bString after it is parsed
        
        int lineArraySize = lineArray.size();
        
        int numValues = lineArraySize * 3;
        ArrayList<Integer> changeValues = new ArrayList<Integer>(); // New ArrayList of Integers, used to store all integer values in text file, in order.
        
        if (numTick < 1){
            System.out.println("Number of Points: " + lineArraySize);
        }
        
        int i = 0;
        int j = 0;
        int h = 0;
        while(i <= (lineArraySize-1)) { //Takes in 4 lines from the text file. Can be raised if necessary.
            String aString = lineArray.get(i); //String aString holds the string at point i in the ArrayList<String> lineArray
            String[] aStringSplitted = aString.split(" ");//String Array aStringSplitted holds each of the three values on each line in the text file. These values, though numbers, are stored as string values.
            while (j < 3){ //So this while loop parses the values into integers and stores the new values in a new
                String bString = aStringSplitted[j]; //String bString stores the value of aStringSplitted at point j
                bStringParsed = Integer.parseInt(bString);
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
        if (whatToPrint == 1){
            fileScan = new Scanner (new File("../txt/cube.txt"));
        }
        else if (whatToPrint  == 2){
            fileScan = new Scanner (new File("../txt/triangle.txt"));
        }
        else if (whatToPrint  == 3){
            fileScan = new Scanner (new File("../txt/square.txt"));
        }
        else if (whatToPrint  == 4){
            fileScan = new Scanner (new File("../txt/solid.txt"));
        }
        else if (whatToPrint  == 2){
            fileScan = new Scanner (new File("../Desktop/simulation/triangle.txt"));
        }
        else if (whatToPrint  == 3){
            fileScan = new Scanner (new File("../Desktop/simulation/square.txt"));
        }
        else if (whatToPrint  == 4){
            fileScan = new Scanner (new File("../Desktop/simulation/solid.txt"));
        }
        else{
            fileScan = new Scanner (new File("../Desktop/simulation/Change.txt"));
        }
        while(fileScan.hasNext()){
            sentence = fileScan.nextLine();
            lineArray.add(sentence); // add() appends each line to lineArray
        }
        return lineArray;
    }
    public static int k = 0;
    
    public static void tick(JFrame f, JFrame z) throws FileNotFoundException {
        numTick++;
        List<Integer> changeValues = new ArrayList<Integer>();
        changeValues = getValues();
        
        Quadcopter.posX = changeValues.get(k);
        Quadcopter.posY = changeValues.get(k+1);
        
        
        System.out.println(Quadcopter.posX + "x, " + Quadcopter.posY + "y, " + Quadcopter.posZ + "z");

        try {
            if (whatToPrint  == 4){
                Thread.sleep(50);
            }
            else{
                Thread.sleep(500);
            }
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        if (k < changeValues.size() - 3){
            k += 3;
        }
        
        
        Screen s = new Screen();
        f.add(s);
        f.setVisible(true);
        
    }
    
    public static void setup() {
        Quadcopter.posX = 0;
        Quadcopter.posY = 0;
        Quadcopter.posZ = 0;
        Quadcopter.isFlying(Quadcopter.posZ);
    }
    
}