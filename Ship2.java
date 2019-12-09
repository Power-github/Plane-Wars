import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *飞船类，用来表示玩家控制的太空飞船
 */
public class Ship extends Sprite {
   
    private int gunHeat = 0;
    
    public Ship(int x,int y){
        super(x,y);
    }

    public void act() 
    {
       checkKeys();
       handleShotCollision();       
    } 
   
    public void checkKeys()
    {
     if (Greenfoot.isKeyDown("up")){
            move(0,-8);
        }
        
        if (Greenfoot.isKeyDown("down")){
            move(0,8);
        }
        
        if(Greenfoot.isKeyDown("right")){
            move(8,0);
        }
        
        if(Greenfoot.isKeyDown("left")){
            move(-8,0);
        }

        
        if (Greenfoot.isKeyDown("space") && (gunHeat <= 0)) {
            getWorld().addObject(new Laser(), getX(), getY());
            Greenfoot.playSound("shot1.wav");
            gunHeat = 10;
        }      
    }
    
    public void handleShotCollision(){
       if(getOneIntersectingObject(Enemy.class)!=null){
            struckEffect();
            resurrect();
       }
       gunHeat --;
    }
}
