import greenfoot.*;

import java.awt.Color;
import java.applet.*;
import java.awt.*;

/**
 * 生命类，用来记录玩家的剩余生命
 */
public class Live extends Actor{

Font font2=new Font("Helvetica",Font.BOLD,25);
public static int lives = 3;

  public Live(String text)
  {
      GreenfootImage img_field = new GreenfootImage(150,50);
      img_field.setFont(font2);
      img_field.setColor(Color.white);
      img_field.drawString(text,5 , 45);
      setImage(img_field);
   }
   
   public void act(){
       setLive("生命值: " + lives);
       failed();
    }
      
  public void setLive(String text)
   {
       GreenfootImage img_field = getImage();
       img_field.clear();                       //清空全图
       img_field.drawString(text,5, 45);       //绘制分数
       
   }
   
   public void failed(){
       if ( lives <= 0){
            getWorld().setBackground("lose.png");
            Greenfoot.stop();
        }
   }
}
