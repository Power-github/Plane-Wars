import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *�ɴ��࣬������ʾ��ҿ��Ƶ�̫�շɴ�
 */
public class Ship extends Sprite {
   
    private int gunHeat = 0;     //������ʱ��
    public Ship(int x,int y){
        super(x,y);
    }

    public void act() 
    {
       checkKeys();
       handleShotCollision();   
    } 
   
    public void checkKeys()
    {
     if (Greenfoot.isKeyDown("up")){
            move(0,-8);
        }
        
        if (Greenfoot.isKeyDown("down")){
            move(0,8);
        }
        
        if(Greenfoot.isKeyDown("right")){
            move(8,0);
        }
        
        if(Greenfoot.isKeyDown("left")){
            move(-8,0);
        }

        
        if (Greenfoot.isKeyDown("space") && (gunHeat <= 0)) {
            getWorld().addObject(new Laser(-25), getX(), getY());
            Greenfoot.playSound("shot1.wav");
            gunHeat = 10;
        }      
    }
    
    public void handleShotCollision(){
       if(getOneIntersectingObject(Enemy.class)!=null){
            Actor enemy = getOneIntersectingObject(Enemy.class);
            struckEffect();
            resurrect();
            Live.lives--;
       }
       
       if(getOneIntersectingObject(BOSS.class)!=null){
            Actor boss = getOneIntersectingObject(BOSS.class);
            getWorld().removeObject(boss);
            struckEffect();
            resurrect();
            Live.lives--;
       }
       
       if(getOneIntersectingObject(Enemy_La.class)!=null){
            Actor enemy_La = getOneIntersectingObject(Enemy_La.class);
            getWorld().removeObject(enemy_La);
            struckEffect();
            resurrect();
            Live.lives--;
       }
       
       if(getOneIntersectingObject(Follow.class)!=null){
            Actor follow = getOneIntersectingObject(Follow.class);
            getWorld().removeObject(follow);
            struckEffect();
            resurrect();
            Live.lives--;
       }
       gunHeat --;
    }
    
}
