import greenfoot.*;

import java.awt.Color;
import java.applet.*;
import java.awt.*;
/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    Font font2=new Font("Helvetica",Font.BOLD,25);

    public Start(){
      /*  GreenfootImage img_field = new GreenfootImage(150,50);
       img_field.setFont(font2);
       img_field.setColor(Color.white);
       img_field.drawString("¿ªÊ¼ÓÎÏ·",5 , 45);
       setImage(img_field);*/
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
           Space.isPause = false;
           getWorld().removeObjects(getWorld().getObjects(Start.class));
        }
    }    
}
