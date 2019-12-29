import greenfoot.*;

import java.awt.Color;
import java.applet.*;
import java.awt.*;

/**
 * �����࣬������¼��ҵ�ʣ������
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
       setLive("����ֵ: " + lives);
       failed();
    }
      
  public void setLive(String text)
   {
       GreenfootImage img_field = getImage();
       img_field.clear();                       //���ȫͼ
       img_field.drawString(text,5, 45);       //���Ʒ���
       
   }
   
   public void failed(){
       if ( lives <= 0){
            getWorld().setBackground("lose.png");
            Greenfoot.stop();
        }
   }
}
