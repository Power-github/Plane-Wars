import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * 激光类，用来表示飞船发射的武器
 */
public class Laser extends Sprite
{
 private int Laser_speed;      //子弹飞行速度
  public Laser(int speed)
  {
      super(0,0);  
      this.Laser_speed = speed;
      GreenfootImage laser = new GreenfootImage("bullet1.jpg");
      setImage(laser);      
  }
  
    public void act(){
       
        move(0,Laser_speed);
        handleShotCollision();
    }  
    
    public void handleShotCollision(){
        
        if(getY()<=0){
            getWorld().removeObject(this);
            return;
        }
    }
}
