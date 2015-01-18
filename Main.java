package simulation;

public class Main {
	
	public static void main(String[] args) {
        
		System.out.println("Welcome to the simulation");
        setup();
        
	}
    
    public static void setup() {
        
        Quadcopter.RPM1 = 0;
        Quadcopter.RPM2 = 0;
        Quadcopter.RPM3 = 0;
        Quadcopter.RPM4 = 0;
        Quadcopter.posX = 0;
        Quadcopter.posY = 0;
        Quadcopter.posZ = 0;
        
    }
    
}
