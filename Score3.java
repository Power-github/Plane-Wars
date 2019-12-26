import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;
import java.applet.*;
import java.awt.*;

/**
 * 分数类，用来记录玩家的得分
 */
public class Score extends Actor{

Font font1=new Font("Helvetica",Font.BOLD,25);
public static int Score_num = 0;

  public Score(String text)
  {
      GreenfootImage img_field = new GreenfootImage(150,50);
      img_field.setFont(font1);
      img_field.setColor(Color.white);
      img_field.drawString(text, 5, 45);
      setImage(img_field);
   }
   
   public void act(){
       setText("Score: " + Score_num);
       win();
    }
      
  public void setText(String text)
   {
       GreenfootImage img_field = getImage();
       img_field.clear();                       //清空全图
       img_field.drawString(text, 5, 45);       //绘制分数
       
   }
   
   public void win()
    {
        if (Score.Score_num >= 100){
            getWorld().setBackground("win.png");
            Greenfoot.stop();
        }
    }
}