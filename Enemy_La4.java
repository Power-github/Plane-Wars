import greenfoot.*;

/**
 * Write a description of class Enemy_La here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_La extends Sprite
{
  private int EnLaser_speed;      //子弹飞行速度
  private int X_speed;
  public Enemy_La (int X_speed,int speed)
  {
      super(0,0);  
      this.EnLaser_speed = speed;
      this.X_speed = X_speed;
      GreenfootImage laser = new GreenfootImage("bullet1.jpg");
      setImage(laser);      
  }
  
    public void act() 
    {
        move(0,EnLaser_speed);
        handleShotCollision();
    }    
    
    public void handleShotCollision(){
        if(getY()>=getWorld().getHeight()){
            getWorld().removeObject(this);
            return;
        }
    }
}
