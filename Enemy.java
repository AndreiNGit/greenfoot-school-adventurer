import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    protected int attackSpeed;
    protected int attackRange;
    protected int randMoveCounter = 0;
    protected Hero hero;
    
    void checkLife()
    {
        if(health <= 0 && getWorld() != null)
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }
    
    void randomMove()
    {
        //Sistemul schimba locatia inamicilor intr-o directie aleatorie si la un timp aleatoriu
        if(Greenfoot.getRandomNumber(5000) < 5)
        {
            randomMove = true;
        }
        if(randomMove)
        {
            randMoveCounter++;
            if(randMoveCounter < 5)
            {
                turn(Greenfoot.getRandomNumber(90)-45);
            }
            if(randMoveCounter < 50)
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
    
    void atEdge()
    {
        if(isAtEdge())
        {
            turn(180);
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
