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
    public static int changeX;
    public static int changeY;
    public static int changeZ;
    
    public static int changeX(int RPM1, int RPM3) {
        
        changeX = (RPM1 - RPM3);
        return changeX;
        
    }
    
    public static int changeY(int RPM2, int RPM4) {
        
        changeY = (RPM2 - RPM4);
        return changeY;
        
    }
    
    public static int changeZ(int RPM1, int RPM2, int RPM3, int RPM4) {
        
        changeZ = RPM1 + RPM2 + RPM3 + RPM4;
        return changeZ;
        
    }
    
    public static int RPM1() {
        
        RPM1 = 30;
        return RPM1;
        
    }
    
    public static int RPM2() {
        
        RPM2 = 30;
        return RPM2;
        
    }
    
    public static int RPM3() {
        
        RPM3 = 60;
        return RPM3;
        
    }
    
    public static int RPM4() {
        
        RPM4 = 30;
        return RPM4;
        
    }
    
    public static int posZ() {
        
        posZ = posZ + changeZ;
        return posZ;
        
    }
    
    public static int posY() {
        
        posY = posY + changeY;
        return posY;
        
    }
    
    public static int posX() {
        
        posX = posX + changeX;
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