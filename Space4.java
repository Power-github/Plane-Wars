import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * 太空类，用来表示游戏运行的场景
 */
public class Space extends World
{
public Score score_field;
public int num = 1;                 //循环积分变量 ---初始值为1
private int Enemy_num = 0;
private int scrollY = 0;            //竖直滚动坐标
private int scrollSpeed = 3;        //滚动速度
private GreenfootImage backIm1,backIm2;                 //保存背景图像

public static boolean isPause = true;
private int Pausetime = 100;
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 10x10 pixels.
        super(440, 782, 1);
        setBackground("背景.jpg");
        backIm1 = backIm2 = new GreenfootImage(getBackground());
        Score score_field = new Score("Score: 0");
        addObject(score_field, 80, 40);
        
        Live live_field = new Live("生命值: 3");
        addObject(live_field, 80, 740);
        
        Grade grade_field = new Grade("grade: 1");
        addObject(grade_field, 220, 40);
        
        Start start = new Start();
        addObject(start,240,350);
       
        Ship ship = new Ship(220,700);        
        addObject(ship, 220, 700);
        createStars(50);
        
        setPaintOrder(Ship.class, Laser.class, Enemy.class, Stars.class);
        
  }
  
   public void act(){
      if(!isPause){
           /*if(isPause && Pausetime == 100){
             Greenfoot.stop();
             Greenfoot.delay(100);
             Greenfoot.start();
             addObject(new Replay("重新开始"),220,350);
          }*/
          scrollBackground();
          if(num-score_field.Score_num <= 1){
             num = score_field.Score_num +1;
          }
          if(Enemy_num < Grade.grades){
             for(int i = Enemy_num;i<Grade.grades;i++){
                int speed = Greenfoot.getRandomNumber(3) + Grade.grades ;
                addObject(new Enemy(score_field,getWidth()+1,Greenfoot.getRandomNumber(400),speed), Greenfoot.getRandomNumber(440),0);
                Enemy_num++;
             } 
          }
          if( num % 20 == 1 && num/20 > 0){
               int speed =  Grade.grades * 2;
               addObject(new BOSS(score_field,getWidth()+1,Greenfoot.getRandomNumber(400),speed), Greenfoot.getRandomNumber(400),0);
               num++;
           }
          else if(num%26 == 1 && num/26 >0){
                int speed = Greenfoot.getRandomNumber(3) + (score_field.Score_num/13) * 2;
                addObject(new Follow(score_field,getWidth()+1,Greenfoot.getRandomNumber(400),speed,speed),Greenfoot.getRandomNumber(400) ,0);
                num++;
           }
          else if(num%31 == 1 && num/31 > 0){
               addObject(new BUFF(Greenfoot.getRandomNumber(440),0),Greenfoot.getRandomNumber(440),0);
               num++;
           }
          else if(num%51 == 1 && num/51 > 0){
               addObject(new Addlive(Greenfoot.getRandomNumber(440),0),Greenfoot.getRandomNumber(440),0);
               num++;
           }
          else if(num% 35== 1 && num/35 > 0){
               addObject(new DEBUFF(Greenfoot.getRandomNumber(440),0),Greenfoot.getRandomNumber(440),0);
               num++;
           }
        
        
        
        }
      
    }
    
    private void createStars(int number)                    //创建星星
    {   
    
      for(int i = 0; i < number; i++)
      {
        int x = Greenfoot.getRandomNumber( getWidth() );   
        int y = Greenfoot.getRandomNumber( getHeight() );
        addObject(new Stars(), x, y);
      }
    }
    //重新设置场景图像
    public void resetBackImage(){
        GreenfootImage back = getBackground();
        back.drawImage(backIm1,0,scrollY);
        back.drawImage(backIm2,0,getHeight()+scrollY);
    }
    //滚动场景图像
    public void scrollBackground(){
        scrollY = (scrollY - scrollSpeed) % getHeight();
        resetBackImage();
    }
}
