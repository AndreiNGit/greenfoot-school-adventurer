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
    protected SimpleTimer attackTimer = new SimpleTimer();
    protected int attackRange;
    protected int attackCooldown;
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
    
    void Collision()
    {
        if(this.isTouching(Wall.class) || this.isTouching(Chest.class))
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
    
    void enemyCollision()
    {
        // Actor up = getOneObjectAtOffset(0, -10, Enemy.class);
        // Actor down = getOneObjectAtOffset(0, 10, Enemy.class);
        // Actor right = getOneObjectAtOffset(10, 0, Enemy.class);
        // Actor left = getOneObjectAtOffset(-10, 0, Enemy.class);
        // if(up != null)
        // {
            // setLocation(getX(), getY() + speed);
        // }
        // if(down != null)
        // {
            // setLocation(getX(), getY() - speed);
        // }
        // if(right != null)
        // {
            // setLocation(getX() - speed, getY());
        // }
        // if(left != null)
        // {
            // setLocation(getX() + speed, getY());
        // }
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
