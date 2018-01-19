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
    public CloseEnemy(Hero _hero)
    {
        speed = 2;
        damage = 13;
        health = 100;
        attackSpeed = 230;
        attackRange = 5;
        hero = _hero;
    }
    
    public void act() 
    {
        frameCounter++;
        checkLife();
        attack();
    }
    
    void attack()
    {
        //Daca eroul este in apropiere atunci inamicul il urmareste pana ajunge in raza de atac si il ataca
        if(this.getWorld() != null )
        {
            List<Hero> heroList = getObjectsInRange(100, Hero.class);
            if(!heroList.isEmpty())
            {
                Hero hero = (Hero)heroList.get(0);
                if(!isTouching(Hero.class))
                {
                    turnTowards(hero.getX() , hero.getY());
                    move(speed);
                    isAttacked = false;
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
                //Daca eroul nu se afla in apropiere atunci executa metodele:
                randomMove();
                atEdge();
                checkForEnemyTrigger();
            }
        }
    }
}