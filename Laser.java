import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * �����࣬������ʾ�ɴ����������
 */
public class Laser extends Sprite
{

  public Laser()
  {
      super(0,0);  
      GreenfootImage laser = new GreenfootImage("bullet1.png");
      setImage(laser);      
  }
  
    public void act(){
       
        move(0,-25);
        handleShotCollision();
    }  
    
    public void handleShotCollision(){
        
        if(getY()<=0){
            getWorld().removeObject(this);
        }
    }
}
