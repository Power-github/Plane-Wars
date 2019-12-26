import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 精灵类，用来作为所有角色的父类
 */
public abstract class Sprite extends Actor
{
    private int locX;
    private int locY;
    private int curdx;
    private int curdy;
        
    public Sprite(int x,int y)
    {
        locX = x;
        locY = y;
        curdx=0;
        curdy=0;
        super.setLocation(locX,locY);
    }
    
    public void move(int dx,int dy) {
        curdx=dx;
        curdy=dy;
        locX=locX+curdx;
        locY=locY+curdy;
        super.setLocation( locX, locY);
    }
   
    public void setLocation(int x, int y) 
    {
        locX = x;
        locY = y;
        super.setLocation(locX,locY);
    }

    public int getX() 
    {
        return locX;
    }

    public int getY() 
    {
        return locY;
    }
    
    public void setX(int x){
        locX=x;
    }
    
    public void setY(int y){
        locY=y;
    }
    
    public int getDX() 
    {
        return curdx;
    }

    public int getDY() 
    {
        return curdy;
    }
    
    public void setDX(int dx){
        curdx=dx;
    }
    
    public void setDY(int dy){
        curdy=dy;
    }
   
    public void struckEffect(){       //爆炸特效
        getWorld().addObject(new Explosion(), getX(), getY());
        Greenfoot.playSound("explosion.wav");
    }
    
    protected void resurrect(){
        int x,y;
        int dx=0;
        if(this instanceof Ship){                    //检测是否是飞机类的实例
            x=220;
            y=700;
        }
        else{                                       
            x=Greenfoot.getRandomNumber(440);
            y=0;
        }
        setLocation(x,y);
    }
    
    public abstract void handleShotCollision();
}
