import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Character
{
    protected boolean randomMove = false;
    protected boolean isAttacked = false;
    protected SimpleTimer attackTimer = new SimpleTimer();
    protected int attackRange;
    protected int attackCooldown;
    protected int randMoveCounter = 0;
    protected Hero hero = Dungeon1.hero;
    
    private static final int rEnemyXp = 6;
    private static final int cEnemyXp = 4;
    
    void checkLife()
    {
        if(health <= 0 && getWorld() != null)
        {
            World world = getWorld();
            world.removeObject(this);
            if(this.getClass() == RangeEnemy.class)
            {
                hero.addXp(rEnemyXp);
            }
            else if(this.getClass() == CloseEnemy.class)
            {
                hero.addXp(cEnemyXp);
            }
        }
    }
    
    void randomMove()
    {
        //Sistemul schimba locatia inamicilor intr-o directie aleatorie si la un timp aleatoriu
        if(this instanceof Boss)
        {
            if(Greenfoot.getRandomNumber(1500) < 10)
            {
                randomMove = true;
            }
        }
        else
        {
            if(Greenfoot.getRandomNumber(2700) < 5)
            {
                randomMove = true;
            }
        }
        if(randomMove)
        {
            randMoveCounter++;
            if(randMoveCounter < 5)
            {
                turn(Greenfoot.getRandomNumber(90)-45);
            }
            if(randMoveCounter < 25)
            {
                move(speed);
            }
            else
            {
                randomMove = false;
                randMoveCounter = 0;
            }
        }
    }
    
    void collision()
    {
        if(this.isTouching(Wall.class))
        {
            turn(180);
            move(speed);
        }
    }
    
    void checkForEnemyTrigger()
    {
        //Metoda verifica daca inamicul a fost atacat in afara range-ului lui si urmareste caracterul
        if(this.getWorld() != null)
        {
            int dx = getDistanceX(this.getX(), hero.getX());
            int dy = getDistanceY(this.getY(), hero.getY());
            Actor arrow = getOneIntersectingObject(Arrow.class);
            if(arrow != null)
            {
                isAttacked = true;
            }
            if(isAttacked && (dx > attackRange || dy > attackRange || dy < -attackRange || dx < -attackRange))
            {
                turnTowards(hero.getX(), hero.getY());
                move(speed);
            }
        }
    }
    
    int getDistanceX(int enemyX, int heroX)
    {
        return enemyX - heroX;
    }
    
    int getDistanceY(int enemyY, int heroY)
    {
        return enemyY - heroY;
    }
}
