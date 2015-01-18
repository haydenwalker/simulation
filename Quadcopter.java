package simulation;

public class Quadcopter {

    public static boolean isFlying;
    public static int pos;
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
    
    public static int pos() {
        
        pos = 0;
        return pos;
        
    }
    
    public static boolean isFlying() {
        
        isFlying = true;
        return isFlying;
        
    }

}