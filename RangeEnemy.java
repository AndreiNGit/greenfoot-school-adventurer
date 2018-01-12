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
    private int shootDistance;
    
    public RangeEnemy(Hero _hero)
    {
        speed = 1;
        health = 100;
        shootDistance = 100;
        attackSpeed = 180;
        hero = _hero;
    }
    
    public void act() 
    {
        checkLife();
        frameCounter++;
        attack();
        //System.out.println("RangeEnemy health:" + health);
    }
    
    void attack()
    {
        if(this.getWorld() != null )
        {
            List<Hero> heroList = getObjectsInRange(200, Hero.class);
            if(!heroList.isEmpty())
            {
                Hero hero = (Hero)heroList.get(0);
                int dx = getDistanceX(this.getX(), hero.getX());
                int dy = getDistanceY(this.getY(), hero.getY());
                if(dx > shootDistance || dy > shootDistance || dx < -shootDistance || dy < -shootDistance)
                {
                    turnTowards(hero.getX(), hero.getY());
                    move(speed);
                }
                else
                {
                    if(frameCounter > attackSpeed)
                    {
                        FireBall fireball = new FireBall(this);
                        getWorld().addObject(fireball, this.getX(), this.getY());
                        fireball.turnTowards(hero.getX(), hero.getY());
                        frameCounter = 0;
                    }
                }
            }
            else
            {
                moveRandom();
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