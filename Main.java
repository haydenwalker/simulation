package simulation;

import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {
        
        JFrame f = new JFrame("Quadcopter Simulation");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Welcome to the simulation");
        setup();
        int i = 0;
        while(i <= 10) {
            tick(f);
            i += 1;
        }
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
        f.setSize(1000, 1000);
        f.setVisible(true);
        System.out.println(Quadcopter.posX + "x, " + Quadcopter.posY + "y, " + Quadcopter.posZ + "z");
        try {
            Thread.sleep(4000);
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