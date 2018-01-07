import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.String;
/**
 * Write a description of class Hero here.
 * 
 * @author Andrei Nicusor
 * @version 1.5
 */
public class Hero extends Actor
{
    private int speed;
    private int health;
    private int damage;
    private int attackSpeed;
    private static int frameCounter = 0;
    
    public Hero()
    {
        speed = 2;
        damage = 10;
        health = 100;
        attackSpeed = 50;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int _var)
    {
        health = _var;
    }
    
    public void act() 
    {
        //for testing
        //System.out.println("health: " + health);
        //System.out.println("frame: " + frameCounter);
        //for testing
        
        frameCounter++;
        gameOver();
        move();
        MeleeAttack();
    }
    
    void move()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - speed);
            //move(speed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
        }
    }
    
    void MeleeAttack()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
            if(enemy != null && frameCounter >= attackSpeed)
            {
                enemy.health -= damage;
            }
        }
    }
    
    void gameOver()
    {
        if (health <= 0)
        {
            Greenfoot.stop();
        }
    }
    
    void checkFrameCounter()
    {
        if(frameCounter > 30000)
        {
            frameCounter = 0;
        }
    }
}