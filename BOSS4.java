import greenfoot.*;

/**
 * Write a description of class BOSS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BOSS extends Sprite
{
    private int lives = 2;
    private int speed;
    private int gunHeat = 0;     //Éä»÷¼ä¸ôÊ±¼ä
    public BOSS(Score score_field,int x,int y,int speed){
        super(x,y);
        this.speed = speed;
        
    }
   
    public void act() 
    {
        move(0,speed);
        heat();
        handleShotCollision();
       // win();
    }   
    
    public void scoreOfGame(int ct)
    {
         Score.Score_num+=ct;  
    }
    
    /*public void win(){
        if(lives<=0){
            getWorld().setBackground("win.png");
            Greenfoot.stop();
        }
    }*/
    
    public void handleShotCollision(){
        if (getY() >= (getWorld().getHeight()-10)){   
            getWorld().removeObject(this);
            return;
         }
         
         if(getOneIntersectingObject(Laser.class) != null){
            Actor laser = getOneIntersectingObject(Laser.class);
            getWorld().removeObject(laser);
            Greenfoot.playSound("explosion.wav");
            lives--;
            if(lives <= 0){
                getWorld().removeObject(this);
                //struckEffect();
                scoreOfGame(2);
            }
        }
        gunHeat--;
    }
    
    public void heat(){
        if ( gunHeat <= 0 ) {
            getWorld().addObject(new Enemy_La(0,Grade.grades * 3), getX(), getY());
            Greenfoot.playSound("shot1.wav");
            gunHeat = 100;
        }
    }
}
