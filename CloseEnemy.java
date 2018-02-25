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
        attackRange = 25;
        attackCooldown = 1200;
    }
    
    public void act() 
    {
        checkLife();
        attack();
    }
    
    void attack()
    {
        //Daca eroul este in apropiere atunci inamicul il urmareste pana ajunge in raza de atac si il ataca
        if(this.getWorld() != null )
        {
            int dx = getDistanceX(this.getX(), hero.getX()); //calculeaza distanta dintre erou si inamic
            int dy = getDistanceY(this.getY(), hero.getY()); 
            List<Hero> heroList = getObjectsInRange(150, Hero.class); //cauta eroul
            if(!heroList.isEmpty())
            {
                Hero hero = (Hero)heroList.get(0);
                if(dx > attackRange || dy > attackRange || dx < -attackRange || dy < -attackRange)
                {
                    //daca eroul nu se afla in raza de atac atunci urmareste-l
                    attackTimer.mark();
                    turnTowards(hero.getX() , hero.getY());
                    move(speed);                  
                    isAttacked = false; //daca eroul a atacat inamicul cat timp era in afara razei vizuale a inamicului atunci urmareste eroul pana ajunge in raza de atac
                }
                else
                {
                    if(attackTimer.millisElapsed() > attackCooldown)
                    {
                        hero.setHealth(hero.getHealth() - damage);
                        hero.updateHealthStatus();
                        attackTimer.mark();
                    }
                }
            }
            else
            {
                //Daca eroul nu se afla in apropiere atunci executa metodele:
                randomMove();
                collision();
                checkForEnemyTrigger();
            }
        }
    }
}