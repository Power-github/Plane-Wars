import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * 太空类，用来表示游戏运行的场景
 */
public class Space extends World
{
public Score score_field;
public int num = 1;                 //循环积分变量 ---初始值为1
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 10x10 pixels.
        super(440, 782, 1);
        
        Score score_field = new Score("Score: 0");
        addObject(score_field, 80, 40);
        
        Live live_field = new Live("生命值: 5");
        addObject(live_field, 80, 740);
        
        for(int i = 0;i<3;i++){
            int speed = Greenfoot.getRandomNumber(3) + 5;
            addObject(new Enemy(score_field,getWidth()+1,Greenfoot.getRandomNumber(400),speed), Greenfoot.getRandomNumber(440),0);
            Greenfoot.delay(3);
        }
       
        Ship ship = new Ship(220,700);        
        addObject(ship, 220, 700);
        
        createStars(50);
        
        setPaintOrder(Ship.class, Laser.class, Enemy.class, Stars.class);
        
  }
  
  public void act(){
      if(num-score_field.Score_num <= 1){
          num = score_field.Score_num +1;
        }
      if( num % 5 == 1 && num/5 > 0){
          addObject(new BOSS(score_field,getWidth()+1,Greenfoot.getRandomNumber(400),3), Greenfoot.getRandomNumber(400),0);
          num++;
        }
      else if(num%13 == 1 && num/13 >0){
          addObject(new Follow(score_field,getWidth()+1,Greenfoot.getRandomNumber(400),3,3),Greenfoot.getRandomNumber(400) ,0);
          num++;
        }
     
    }
    
    private void createStars(int number)
    {   
    
      for(int i = 0; i < number; i++)
      {
        int x = Greenfoot.getRandomNumber( getWidth() );   
        int y = Greenfoot.getRandomNumber( getHeight() );
        addObject(new Stars(), x, y);
      }
   
    }
}
