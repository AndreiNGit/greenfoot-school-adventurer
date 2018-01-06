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
        speed = 2;
        damage = 10;
        health = 100;
        attackSpeed = 50;
    }
    
    public void act() 
    {
        //System.out.println("CloseEnemy health:" + health);
        attackHero();
    }
    
    void attackHero()
    {
        List<Hero> heroList = getObjectsInRange(100, Hero.class);
        if(!heroList.isEmpty())
        {
            System.out.println("FOUND FOUND FOUND FOUND");
            Hero hero = (Hero)heroList.get(0);
            if(!isTouching(Hero.class))
            {
                turnTowards(hero.getX() , hero.getY());
                move(speed);
            }
            else
            {
                hero.setHealth(hero.getHealth() - damage);
            }
        }
    }
}
