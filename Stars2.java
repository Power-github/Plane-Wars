import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 *  �ǿ��࣬������ʾ̫���е�����
 */
public class Stars  extends Actor
{
    public Stars() 
    { 
        int x = 2;
        int y = 2;
        GreenfootImage star = new GreenfootImage(4, 4);
        star.setColor(Color.WHITE);
        star.fillOval(1,1, 4, 4);
        setImage(star);
    }    
    
    public void act(){        
        setLocation (getX() , getY()-1);       
        if (getY() <= 5){
            setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), getWorld().getHeight());       
        }     
    }   
}
