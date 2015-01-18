package simulation;

public class Main {
	
	public static void main(String[] args) {
        
		System.out.println("Welcome to the simulation");
        setup();
        int i = 0;
        while(i <= 10) {
            tick();
            i += 1;
        }
	}
    
    public static void tick() {
        
        Quadcopter.RPM1();
        Quadcopter.RPM2();
        Quadcopter.RPM3();
        Quadcopter.RPM4();
        Quadcopter.changeX(Quadcopter.RPM1, Quadcopter.RPM3);
        Quadcopter.changeY(Quadcopter.RPM2, Quadcopter.RPM4);
        Quadcopter.changeZ(Quadcopter.RPM1, Quadcopter.RPM2, Quadcopter.RPM3, Quadcopter.RPM4);
        Quadcopter.posX();
        Quadcopter.posY();
        Quadcopter.posZ();
        Quadcopter.isFlying(Quadcopter.posZ);
        
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