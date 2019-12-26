import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Follow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Follow extends Sprite
{
    private Score scoreNum;
    private int X_speed;
    private int speed;
    private int X_sp;
    private int sp;
    public Follow(Score score_field,int x,int y,int X_speed,int speed)
    {
        super(x,y);
        this.speed = speed;
        this.X_speed = X_speed;
        scoreNum = score_field;
    }
    
    public void act() 
    {
        if(getObjectsInRange(400,Ship.class) != null && getObjectsInRange(400,Ship.class).size() !=0){
            follow();
            handleShotCollision();
        }
        else{
            move(0,speed);
            handleShotCollision();
        }
    }  
    
    public void scoreOfGame(int ct)
    { 
       
    }
    
    public void handleShotCollision(){
        if (getY() >= getWorld().getHeight()){   
            resurrect();
         }
         
         if(getOneIntersectingObject(Laser.class) != null){
            Actor laser = getOneIntersectingObject(Laser.class);
            getWorld().removeObject(laser);
            struckEffect();
            scoreOfGame(2); 
            getWorld().removeObject(this);
        }
    }
    
    public void follow(){
        if(getObjectsInRange(400,Ship.class) != null && getObjectsInRange(400,Ship.class).size() !=0 ){
            List<Ship> ships = getObjectsInRange(400,Ship.class);
            Ship ship = ships.get(0);
            if(getX()>ship.getX()){
                X_sp = - X_speed;
            }
            if(getX()<ship.getX()){
                X_sp = X_speed;
            }
            if(getX()==ship.getX()){
                X_sp = 0;
            }
            if(getY()>ship.getY()){
                sp = - speed;
            }
            if(getY()<ship.getY()){
                sp = speed;
            }
            if(getY()==ship.getY()){
                sp = 0;
            }
            move(X_sp,sp);
        }
         
    }
}
