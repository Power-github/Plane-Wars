import greenfoot.*;

/**
 * Write a description of class DEBUFF here.
 * 
 * 
 */
public class DEBUFF extends Sprite
{
    public DEBUFF(int x,int y){
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
            Ship.Ship_speed -= 2; 
            getWorld().removeObject(this);
            return;
        }
    }
}
