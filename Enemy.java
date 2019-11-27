import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 敌机类，用来表示敌方的飞行器
 */
public class Enemy extends Sprite
{

    private Score scoreNum;
    public int count = 0;

    public Enemy(Score score_field,int x,int y)
    {
        super(x,y);
        scoreNum = score_field;
    } 
  
    public void act() 
    {
        move(0,6);
        handleShotCollision();
        win();
    }      
         
    public void scoreOfGame(int ct)
    {
         count=count+ct;                 
         scoreNum.setText("Score: " + count);                        
    }
           
    public void win()
    {
        if (count > 10){
            getWorld().setBackground("win.png");
           /* getWorld().removeObject(this);*/
        }
    }
    
    public void handleShotCollision(){
        if (getY() >= getWorld().getHeight()){
            scoreOfGame(-1);   
            resurrect();
         }
         
         if(getOneIntersectingObject(Laser.class) != null){
            Actor laser = getOneIntersectingObject(Laser.class);
            getWorld().removeObject(laser);
            struckEffect();
            scoreOfGame(1); 
            resurrect();
        }
    }
}
