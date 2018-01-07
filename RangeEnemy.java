import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class RangeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RangeEnemy extends Enemy
{
    public RangeEnemy()
    {
        speed = 2;
        damage = 10;
        health = 100;
    }
    
    public void act() 
    {
        frameCounter++;
        attack();
        //System.out.println("RangeEnemy health:" + health);
    }
    
    void attack()
    {
         if(this.getWorld() != null )
        {
            List<Hero> heroList = getObjectsInRange(150, Hero.class);
            if(!heroList.isEmpty())
            {
                //System.out.println("FOUND FOUND FOUND FOUND");
                Hero hero = (Hero)heroList.get(0);
                int dx = getDistanceX(this.getX(), hero.getX());
                int dy = getDistanceY(this.getY(), hero.getY());
                if(dx > 60 || dy > 60)
                {
                    turnTowards(hero.getX(), hero.getY());
                    move(speed);
                }
                else
                {
                    
                }
            }
        }
    }
    
    private int getDistanceX(int enemyX, int heroX)
    {
        return heroX - enemyX;
    }
    
    private int getDistanceY(int enemyY, int heroY)
    {
        return heroY - enemyY;
    }
}
