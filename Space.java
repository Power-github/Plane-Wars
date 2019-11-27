import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * 太空类，用来表示游戏运行的场景
 */
public class Space extends World
{
public Score score_field;

    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 10x10 pixels.
        super(440, 782, 1);
        
        Score score_field = new Score("Score: 0");
        addObject(score_field, 80, 40);
        
        addObject(new Enemy(score_field,getWidth()+1,Greenfoot.getRandomNumber(400)), Greenfoot.getRandomNumber(440),0);
        
        Ship ship = new Ship(100,200);        
        addObject(ship, 100, 200);
        
        createStars(50);
        
        setPaintOrder(Ship.class, Laser.class, Enemy.class, Stars.class);
        
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
