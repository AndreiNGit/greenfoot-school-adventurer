import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class CloseEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloseEnemy extends Enemy
{
    public CloseEnemy()
    {
        speed = 1;
        damage = 10;
        health = 100;
    }
    
    public void act() 
    {
        frameCounter++;
        System.out.println(frameCounter + " CloseEnemy health :" + health);
        enemyDead();
        attackHero();
    }
    
    void attackHero()
    {
        if(this.getWorld() != null )
        {
            List<Hero> heroList = getObjectsInRange(100, Hero.class);
            if(!heroList.isEmpty())
            {
                //System.out.println("FOUND FOUND FOUND FOUND");
                Hero hero = (Hero)heroList.get(0);
                if(!isTouching(Hero.class))
                {
                    turnTowards(hero.getX() , hero.getY());
                    move(speed);
                }
                else
                {
                    if(frameCounter > 400)
                    {
                        hero.setHealth(hero.getHealth() - damage);
                        frameCounter = 0;
                    }
                }
            }
        }
    }
}