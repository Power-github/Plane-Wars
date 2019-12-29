import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * �����࣬������ʾ�ɴ����������
 */
public class Laser extends Sprite
{
 private int Laser_speed;      //�ӵ������ٶ�
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
