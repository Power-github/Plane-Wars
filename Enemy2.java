import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * �л��࣬������ʾ�з��ķ�����
 */
public class Enemy extends Sprite
{

    private Score scoreNum;
    public int count = 0;
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
        win();
    }      
         
    public void scoreOfGame(int ct)
    {
         count=count+ct;                 
         scoreNum.setText("Score: " + count);                        
    }
           
    public void win()
    {
        if (count > 100){
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
