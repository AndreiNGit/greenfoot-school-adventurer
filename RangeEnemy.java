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
        speed = 1;
        health = 100;
        attackRange = 200;
        attackCooldown = 2000;
    }
    
    public void act() 
    {
        checkLife();
        attack();
    }
    
    void attack()
    {
        if(this.getWorld() != null )
        {
            List<Hero> heroList = getObjectsInRange(300, Hero.class);
            if(!heroList.isEmpty())
            {
                Hero hero = (Hero)heroList.get(0);
                int dx = getDistanceX(this.getX(), hero.getX());
                int dy = getDistanceY(this.getY(), hero.getY());
                if(dx > attackRange || dy > attackRange || dx < -attackRange || dy < -attackRange)
                {
                    turnTowards(hero.getX(), hero.getY());
                    move(speed);
                    isAttacked = false;
                    attackTimer.mark();
                }
                else
                {
                    if(attackTimer.millisElapsed() > attackCooldown)
                    {
                        FireBall fireball = new FireBall(this);
                        getWorld().addObject(fireball, this.getX(), this.getY());
                        fireball.turnTowards(hero.getX(), hero.getY());
                        attackTimer.mark();
                    }
                }
            }
            else
            {
                randomMove();
                collision();
                checkForEnemyTrigger();
            }
        }
    }
}