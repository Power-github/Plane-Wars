import greenfoot.*;
import java.awt.Color;
import java.applet.*;
import java.awt.*;
/**
 * 等级类，用来记录当前游戏难度等级
 * 
 */
public class Grade extends Actor
{
    Font font3=new Font("Helvetica",Font.BOLD,25);
    public static int grades = 1;
    
    public Grade(String text){
         GreenfootImage img_field = new GreenfootImage(150,50);
         img_field.setFont(font3);
         img_field.setColor(Color.white);
         img_field.drawString(text, 5, 45);
         setImage(img_field);
    }
    
    public void act() 
    { 
        grades = ( Score.Score_num /15)+1;
        setGrade("grade: " + grades );
    } 
    
    public void setGrade(String text)
   {
       GreenfootImage img_field = getImage();
       img_field.clear();                       //清空全图
       img_field.drawString(text, 5, 45);       //绘制等级
       
   }
}
