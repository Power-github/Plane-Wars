import greenfoot.*;

/**
 * Write a description of class Addlive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Addlive extends Sprite
{
    public Addlive(int x,int y){
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
            Live.lives ++; 
            getWorld().removeObject(this);
            return;
        }
    }
}
