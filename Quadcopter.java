package simulation;

public class Quadcopter {

    public static boolean isFlying;
    public static int posX;
    public static int posY;
    public static int posZ;
    public static int RPM1;
    public static int RPM2;
    public static int RPM3;
    public static int RPM4;
    
    public static int RPM1() {
        
        RPM1 = 30;
        return RPM1;
        
    }
    
    public static int RPM2() {
        
        RPM2 = 30;
        return RPM2;
        
    }
    
    public static int RPM3() {
        
        RPM3 = 30;
        return RPM3;
        
    }
    
    public static int RPM4() {
        
        RPM4 = 30;
        return RPM4;
        
    }
    
    public static int posZ() {
        
        posZ = 0;
        return posZ;
        
    }
    
    public static int posY() {
        
        posY = 0;
        return posY;
        
    }
    
    public static int posX() {
        
        posX = 0;
        return posX;
        
    }
    
    public static boolean isFlying(int posZ) {
        
        if(posZ > 0)
            isFlying = true;
        else
            isFlying = false;
            
        return isFlying;
        
    }

}