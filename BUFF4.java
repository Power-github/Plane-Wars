import greenfoot.*;

/**
 * Write a description of class BUFF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BUFF extends Sprite
{
    public BUFF(int x,int y){
        super(x,y);
     }
     
    public void act() 
    {
        move(0,2);
        handleShotCollision();
    }  
    
    public void handleShotCollision(){
        if (getY() >= getWorld().getHeight()){   
            getWorld().removeObject(this);
            return;
         }
         
         if(getOneIntersectingObject(Ship.class) != null){
            Actor ship = getOneIntersectingObject(Ship.class);
            Ship.gun -= 2; 
            getWorld().removeObject(this);
            return;
        }
    }
}