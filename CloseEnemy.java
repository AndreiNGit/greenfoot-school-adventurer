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
    Hero hero;
    
    public CloseEnemy(Hero _hero)
    {
        speed = 1;
        damage = 10;
        health = 100;
        attackSpeed = 350;
        hero = _hero;
    }
    
    public void act() 
    {
        frameCounter++;
        //System.out.println(frameCounter + " CloseEnemy health :" + health);
        checkLife();
        attack();
    }
    
    void attack()
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
                    if(frameCounter > attackSpeed)
                    {
                        hero.setHealth(hero.getHealth() - damage);
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
}