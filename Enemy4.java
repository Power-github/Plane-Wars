import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 敌机类，用来表示敌方的飞行器
 */
public class Enemy extends Sprite
{

    private Score scoreNum;
   /* public int Score_num = 0; */
    private int speed;
    public Enemy(Score score_field,int x,int y,int speed)
    {
        super(x,y);
        this.speed = speed;
        scoreNum = score_field;
    } 
  
    public void act() 
    {
        move(0,speed);
        handleShotCollision();
    }      
         
    public void scoreOfGame(int ct)
    {
         Score.Score_num+=ct;  
         //scoreNum.setText("Score: " + Score.Score_num);
    }
    
    public void handleShotCollision(){
        if (getY() >= getWorld().getHeight()){   
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
    
    public void resurrect(){
        int x,y;
        x=Greenfoot.getRandomNumber(440);
        y=0;
        setLocation(x,y);
    }
}
